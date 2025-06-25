import math
from os import listdir
from os.path import isfile, join
from scipy import stats
import  csv
import statistics

class SelectorScore:
    type : str
    selector: str
    selector_score : float
    page_score : str
    page_and_selector_score: float
    selector_avarage_res : float
    failed: int | None

    def __init__(self,type,selector,selector_score,page_score,page_and_selector_score,selector_avarage_res,failed):
        self.type = type
        self.selector = selector
        self.selector_score = selector_score
        self.page_score =page_score
        self.page_and_selector_score = page_and_selector_score
        self.selector_avarage_res = selector_avarage_res
        self.failed = failed


class Result:
    corr : float
    pvalue : float
    function : str
    selector_w : float
    page_w: float
    page_selector_w : float

    def __init__(self,corr, pvale, function,selector_w, page_w,page_selector_w):
        self.corr=corr
        self.pvalue = pvale
        self.function = function
        self.selector_w= selector_w
        self.page_w = page_w
        self.page_selector_w = page_selector_w


def serialize_csv_score_file(failed_flag,file_path_score,file_path_selector_fail):
    tests = []
    for f in listdir(file_path_score):
        if isfile(join(file_path_score,f)):
            test = []
            with open(join(file_path_score,f),newline='') as file:
                if file_path_selector_fail is None:
                        lettore_csv = csv.reader(file, delimiter=',')
                        next(lettore_csv,None)
                        next(lettore_csv,None)
                        for riga in lettore_csv:
                            if failed_flag is True:
                                type,selector,selector_score,page_score,page_and_selector_score,selector_avarage_res, failed = riga
                                selectorscore = SelectorScore(type,selector,selector_score,page_score,page_and_selector_score,selector_avarage_res,failed)
                                test.append(selectorscore)
                            else:
                                type, selector, selector_score, page_score, page_and_selector_score, selector_avarage_res = riga
                                selectorscore = SelectorScore(type, selector, selector_score, page_score,page_and_selector_score, selector_avarage_res, None)
                                test.append(selectorscore)

                else:
                    with open(join(file_path_selector_fail, f), newline='') as file_fail:
                        print(str(f))
                        lettore_csv = csv.reader(file, delimiter=',')
                        lettore_csv_fail = csv.reader(file_fail, delimiter=',')
                        next(lettore_csv, None)
                        next(lettore_csv, None)
                        next(lettore_csv_fail, None)
                        next(lettore_csv_fail, None)
                        for riga in lettore_csv:
                            row_fail = next(lettore_csv_fail,None)
                            #print(row_fail)
                            type, selector, selector_score, page_score, page_and_selector_score, selector_avarage_res = riga
                            type_fail,selector_fail,fail = row_fail
                            selectorscore = SelectorScore(type, selector, selector_score, page_score,page_and_selector_score, selector_avarage_res, fail)
                            test.append(selectorscore)
                            next(lettore_csv_fail,None)
                tests.append(test)
    return tests


def calculate_pass_fail_array(path_res, file_path_score):
    pass_fail = []
    with open(path_res,newline='') as file:
        for f in listdir(file_path_score):
            if isfile(join(file_path_score,f)):
                test_name =  f[0:f.find("_scores")]
                results_csv = csv.reader(file, delimiter=',')
                next(results_csv, None)
                for riga in results_csv:
                    if(riga[0]==test_name):
                        put = 0
                        for cell in riga:
                            if cell=="failed":
                                pass_fail.append(1)
                                put=1
                                break;
                        if put==0:
                            pass_fail.append(0)
                        break
                file.seek(0)
    return pass_fail


def calculate_metric_with_(tests,selector_we,page_we, pageandselector_we,function):
    tests_score = []
    for test in tests:
        selector_score = []
        for selector in test:
            selector_score.append(
                (float(selector.selector_score)*selector_we)+( float(selector.page_score)*page_we)+(float(selector.page_and_selector_score)*pageandselector_we)
            )
        tests_score.append(function(selector_score))
    return tests_score


def create_csv_res_file(name_file,res):
    with open(name_file, 'w',newline='') as file:
        writer = csv.writer(file)
        writer.writerow(['corr','pvalue','function','selector_w','page_w','page_selector_w'])
        for row_res in res:
            row = [ row_res.corr, row_res.pvalue, row_res.function,row_res.selector_w,row_res.page_w,row_res.page_selector_w]
            writer.writerow(row)



def correlation_single_version(file_path_score,file_path_res,result_file_name):

    tests = serialize_csv_score_file(False,file_path_score,None)
    pass_fail = calculate_pass_fail_array(file_path_res, file_path_score)
    results = []
    tests_score = calculate_metric_with_(tests,0,0.5,0.5,statistics.harmonic_mean)
    pointb = stats.pointbiserialr(tests_score,pass_fail)
    res_p = Result(pointb.statistic,pointb.pvalue,statistics.harmonic_mean,0,0.5,0.5)
    results.append(res_p)
    create_csv_res_file(result_file_name,results)


correlation_single_version('Scores_8.1.0','result_10_16.csv','correlation_10_16.csv')
correlation_single_version('Scores_8.1.6','result_16_17.csv','correlation_16_17.csv')
