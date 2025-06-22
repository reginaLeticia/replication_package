
import java.util.List;

public class TestListCreator {
    public static void createPhormerTestList(List<String> fileNames) {
        fileNames.add("src/test/java/JUnit/Phormer/LoginTest.java");
        fileNames.add("src/test/java/JUnit/Phormer/CreateCategoryTest.java");
        fileNames.add("src/test/java/JUnit/Phormer/ModifyCategoryTest.java");
        fileNames.add("src/test/java/JUnit/Phormer/DeleteCategoryTest.java");
        fileNames.add("src/test/java/JUnit/Phormer/CreateStoryTest.java");
        fileNames.add("src/test/java/JUnit/Phormer/ModifyStoryTest.java");
        fileNames.add("src/test/java/JUnit/Phormer/DeleteStoryTest.java");
        fileNames.add("src/test/java/JUnit/Phormer/AddNewPhotoTest.java");
        fileNames.add("src/test/java/JUnit/Phormer/DeletePhotoTest.java");
        fileNames.add("src/test/java/JUnit/Phormer/Selectlast20Test.java");
        fileNames.add("src/test/java/JUnit/Phormer/PhotoGalleryTest.java");
        fileNames.add("src/test/java/JUnit/Phormer/RSSTest.java");
        fileNames.add("src/test/java/JUnit/Phormer/LogoutTest.java");
    }

    public static void createJTracTestList(List<String> fileNames) {
        fileNames.add("src/test/java/JUnit/JTrac/SetItalianLanguageTest.java");
        fileNames.add("src/test/java/JUnit/JTrac/LoginAdminTest.java");
        fileNames.add("src/test/java/JUnit/JTrac/CreateUser1Test.java");
        fileNames.add("src/test/java/JUnit/JTrac/CreateUser2Test.java");
        fileNames.add("src/test/java/JUnit/JTrac/ModifyUser1Test.java");
        fileNames.add("src/test/java/JUnit/JTrac/DeleteUser2Test.java");
        fileNames.add("src/test/java/JUnit/JTrac/CreateSpaceTest.java");
        fileNames.add("src/test/java/JUnit/JTrac/SettingsTest.java");
        fileNames.add("src/test/java/JUnit/JTrac/LogoutAdminTest.java");
        fileNames.add("src/test/java/JUnit/JTrac/LoginUser1Test.java");
        fileNames.add("src/test/java/JUnit/JTrac/BlackboardTest.java");
    }

    public static void createPasswordManagerTestList(List<String> fileNames) {
        fileNames.add("src/test/java/JUnit/PasswordManager/RegisterTest.java");
        fileNames.add("src/test/java/JUnit/PasswordManager/LoginTest.java");
        fileNames.add("src/test/java/JUnit/PasswordManager/AddEntry1Test.java");
        fileNames.add("src/test/java/JUnit/PasswordManager/AddEntry2Test.java");
        fileNames.add("src/test/java/JUnit/PasswordManager/ModifyEntry1Test.java");
        fileNames.add("src/test/java/JUnit/PasswordManager/ModifyEntry2Test.java");
        fileNames.add("src/test/java/JUnit/PasswordManager/ExportCSVTest.java");
        fileNames.add("src/test/java/JUnit/PasswordManager/DeleteEntry1Test.java");
        fileNames.add("src/test/java/JUnit/PasswordManager/DeleteEntry2Test.java");
        fileNames.add("src/test/java/JUnit/PasswordManager/ImportCSVTest.java");
    }

    public static void createClarolineTestList(List<String> fileNames) {
        /* single user test cases. */
        fileNames.add("src/test/java/JUnit/Claroline/AddUserTest.java");
        fileNames.add("src/test/java/JUnit/Claroline/SearchUserTest.java");
        fileNames.add("src/test/java/JUnit/Claroline/LoginUserTest.java");
        fileNames.add("src/test/java/JUnit/Claroline/AddCourseTest.java");
        fileNames.add("src/test/java/JUnit/Claroline/SearchCourseTest.java");
        fileNames.add("src/test/java/JUnit/Claroline/EnrolUserTest.java");

        fileNames.add("src/test/java/JUnit/Claroline/AddCourseEventTest.java");
        fileNames.add("src/test/java/JUnit/Claroline/AddCourseExerciseTest.java");
        fileNames.add("src/test/java/JUnit/Claroline/MakeCourseExerciseVisibleTest.java");
        fileNames.add("src/test/java/JUnit/Claroline/AddCourseExerciseQuestionsTest.java");
        fileNames.add("src/test/java/JUnit/Claroline/DoCourseExerciseQuestionsTest.java");
        fileNames.add("src/test/java/JUnit/Claroline/ViewProfileStatisticsUserTest.java");

                /* multiple users test cases. */
        fileNames.add("src/test/java/JUnit/Claroline/AddMultipleUsersTest.java");
        fileNames.add("src/test/java/JUnit/Claroline/SearchMultipleUsersTest.java");
        fileNames.add("src/test/java/JUnit/Claroline/SearchStudentTest.java");
        fileNames.add("src/test/java/JUnit/Claroline/SearchTeacherTest.java");
        fileNames.add("src/test/java/JUnit/Claroline/SearchAdminTest.java");
        fileNames.add("src/test/java/JUnit/Claroline/EnrolMultipleUsersTest.java");
        fileNames.add("src/test/java/JUnit/Claroline/DoCourseExerciseQuestionsMultipleUsersTest.java");
        fileNames.add("src/test/java/JUnit/Claroline/RemoveEnrolMultipleUsersTest.java");
        fileNames.add("src/test/java/JUnit/Claroline/RemoveMultipleUsersTest.java");

                /* negative test cases. */
        fileNames.add("src/test/java/JUnit/Claroline/AddEmptyUserTest.java");
        fileNames.add("src/test/java/JUnit/Claroline/AddWrongEmailUserTest.java");
        fileNames.add("src/test/java/JUnit/Claroline/AddTwiceUserTest.java");
        fileNames.add("src/test/java/JUnit/Claroline/AddWrongPasswordUserTest.java");
        fileNames.add("src/test/java/JUnit/Claroline/AddEmptyCourseTest.java");
        fileNames.add("src/test/java/JUnit/Claroline/AddDeniedCourseTest.java");
        fileNames.add("src/test/java/JUnit/Claroline/EnrolDeniedCourseTest.java");
        fileNames.add("src/test/java/JUnit/Claroline/AddPasswordCourseTest.java");
        fileNames.add("src/test/java/JUnit/Claroline/EnrolPasswordCourseWrongPasswordUserTest.java");
        fileNames.add("src/test/java/JUnit/Claroline/EnrolPasswordCourseGoodPasswordUserTest.java");

        fileNames.add("src/test/java/JUnit/Claroline/SearchAllowedCourseTest.java");
        fileNames.add("src/test/java/JUnit/Claroline/SearchAndRemovePasswordCourseTest.java");
        fileNames.add("src/test/java/JUnit/Claroline/SearchAndRemoveDeniedCourseTest.java");
        fileNames.add("src/test/java/JUnit/Claroline/RemoveCourseExerciseQuestionsTest.java");
        fileNames.add("src/test/java/JUnit/Claroline/RemoveCourseEventTest.java");
        fileNames.add("src/test/java/JUnit/Claroline/RemoveCourseExerciseTest.java");
        fileNames.add("src/test/java/JUnit/Claroline/RemoveEnrolUserTest.java");
        fileNames.add("src/test/java/JUnit/Claroline/RemoveUserTest.java");
        fileNames.add("src/test/java/JUnit/Claroline/RemoveCourseTest.java");

    }

    public static void createMRBSTestList(List<String> fileNames) {
        fileNames.add("src/test/java/JUnit/MRBS/AddBuildingTest.java");
        fileNames.add("src/test/java/JUnit/MRBS/AddRoomTest.java");
        fileNames.add("src/test/java/JUnit/MRBS/CheckBuildingRoomTest.java");
        fileNames.add("src/test/java/JUnit/MRBS/AddEntryTest.java");
        fileNames.add("src/test/java/JUnit/MRBS/CheckEntryTest.java");
//	SearchEntryTest.java");

        fileNames.add("src/test/java/JUnit/MRBS/AddLongNameBuildingNegativeTest.java");
        fileNames.add("src/test/java/JUnit/MRBS/AddLongNameRoomNegativeTest.java");
        fileNames.add("src/test/java/JUnit/MRBS/SearchEntryNegativeTest.java");
//	AddConflictualEntryNegativeTest.java");
        fileNames.add("src/test/java/JUnit/MRBS/RemoveEntryTest.java");
        fileNames.add("src/test/java/JUnit/MRBS/AddMultipleEntriesSameRoomSameDayTest.java");
        fileNames.add("src/test/java/JUnit/MRBS/AddMultipleEntriesSameRoomDifferentDaysTest.java");
        fileNames.add("src/test/java/JUnit/MRBS/SearchMultipleEntriesTest.java");
        fileNames.add("src/test/java/JUnit/MRBS/RemoveRoomTest.java");
        fileNames.add("src/test/java/JUnit/MRBS/AddMultipleRoomsTest.java");
        fileNames.add("src/test/java/JUnit/MRBS/CheckMultipleBuildingRoomsTest.java");
        fileNames.add("src/test/java/JUnit/MRBS/AddMultipleEntriesDifferentRoomsSameDayTest.java");
        fileNames.add("src/test/java/JUnit/MRBS/AddMultipleEntriesDifferentRoomsDifferentDaysTest.java");
        fileNames.add("src/test/java/JUnit/MRBS/CheckMultipleEntriesTest.java");
        fileNames.add("src/test/java/JUnit/MRBS/RemoveMultipleEntriesTest.java");
        fileNames.add("src/test/java/JUnit/MRBS/RemoveMultipleRoomsTest.java");
        fileNames.add("src/test/java/JUnit/MRBS/AddAndRemoveSerialEntryTest.java");
        fileNames.add("src/test/java/JUnit/MRBS/RemoveBuildingTest.java");
    }

    public static void createMantisBTTestList(List<String> fileNames){
        fileNames.add("src/test/java/JUnit/MantisBT/AddUserTest.java");
        fileNames.add("src/test/java/JUnit/MantisBT/AddUserWrongTest.java");
        fileNames.add("src/test/java/JUnit/MantisBT/AddUserEmptyTest.java");
        fileNames.add("src/test/java/JUnit/MantisBT/AddProjectTest.java");
        fileNames.add("src/test/java/JUnit/MantisBT/AddProjectWrongTest.java");
        fileNames.add("src/test/java/JUnit/MantisBT/AddProjectEmptyTest.java");
        fileNames.add("src/test/java/JUnit/MantisBT/AddCategoryTest.java");
        fileNames.add("src/test/java/JUnit/MantisBT/AddCategoryWrongTest.java");
        fileNames.add("src/test/java/JUnit/MantisBT/AddCategoryEmptyTest.java");
        fileNames.add("src/test/java/JUnit/MantisBT/AddIssueTest.java");
        fileNames.add("src/test/java/JUnit/MantisBT/AddIssueEmptyTest.java");
        fileNames.add("src/test/java/JUnit/MantisBT/AssignIssueTest.java");
        fileNames.add("src/test/java/JUnit/MantisBT/ViewSummaryIssueTest.java");
        fileNames.add("src/test/java/JUnit/MantisBT/UpdateIssuePriorityTest.java");
        fileNames.add("src/test/java/JUnit/MantisBT/UpdateIssueSeverityTest.java");
        fileNames.add("src/test/java/JUnit/MantisBT/UpdateIssueStatusNewTest.java");
        fileNames.add("src/test/java/JUnit/MantisBT/UpdateIssueStatusFeedbackTest.java");
        fileNames.add("src/test/java/JUnit/MantisBT/UpdateIssueStatusAcknowledgedTest.java");
        fileNames.add("src/test/java/JUnit/MantisBT/UpdateIssueStatusConfirmedTest.java");
        fileNames.add("src/test/java/JUnit/MantisBT/UpdateIssueStatusAssignedTest.java");
        fileNames.add("src/test/java/JUnit/MantisBT/UpdateIssueStatusResolvedTest.java");
        fileNames.add("src/test/java/JUnit/MantisBT/UpdateIssueSummaryTest.java");
        fileNames.add("src/test/java/JUnit/MantisBT/UpdateProjectDescriptionTest.java");
        fileNames.add("src/test/java/JUnit/MantisBT/UpdateProjectStatusTest.java");
        fileNames.add("src/test/java/JUnit/MantisBT/UpdateProjectViewStatusTest.java");
        fileNames.add("src/test/java/JUnit/MantisBT/UpdateCategoryTest.java");
        fileNames.add("src/test/java/JUnit/MantisBT/UpdateCategoryEmptyTest.java");
        fileNames.add("src/test/java/JUnit/MantisBT/UpdateUserTest.java");
        fileNames.add("src/test/java/JUnit/MantisBT/UpdateUserEmptyTest.java");
        fileNames.add("src/test/java/JUnit/MantisBT/DeleteCategoryTest.java");
        fileNames.add("src/test/java/JUnit/MantisBT/DeleteIssueTest.java");
        fileNames.add("src/test/java/JUnit/MantisBT/DeleteProjectTest.java");
        fileNames.add("src/test/java/JUnit/MantisBT/DeleteUserTest.java");
        fileNames.add("src/test/java/JUnit/MantisBT/LoginNegativeTest.java");
        fileNames.add("src/test/java/JUnit/MantisBT/LogoutTest.java");
        fileNames.add("src/test/java/JUnit/MantisBT/AddMultipleUsersTest.java");
        fileNames.add("src/test/java/JUnit/MantisBT/DeleteMultipleUsersTest.java");
        fileNames.add("src/test/java/JUnit/MantisBT/AddMultipleSubprojectsTest.java");
        fileNames.add("src/test/java/JUnit/MantisBT/UnlinkMultipleSubprojectsTest.java");
        fileNames.add("src/test/java/JUnit/MantisBT/LinkMultipleSubprojectsTest.java");
        fileNames.add("src/test/java/JUnit/MantisBT/DeleteMultipleSubprojectsTest.java");
    }


    public static void createAddressBookTestList(List<String> fileNames, String version) {

        fileNames.add("src/test/java/JUnit/AddressBook"+version+"/AddressBookAddAddressBookTest.java");
        fileNames.add("src/test/java/JUnit/AddressBook"+version+"/AddressBookSearchAddressBookNameTest.java");
        fileNames.add("src/test/java/JUnit/AddressBook"+version+"/AddressBookSearchAddressBookEmailTest.java");
        fileNames.add("src/test/java/JUnit/AddressBook"+version+"/AddressBookAddGroupTest.java");
        fileNames.add("src/test/java/JUnit/AddressBook"+version+"/AddressBookAssignToGroupTest.java");
        fileNames.add("src/test/java/JUnit/AddressBook"+version+"/AddressBookSearchByGroupTest.java");
        fileNames.add("src/test/java/JUnit/AddressBook"+version+"/AddressBookCheckBirthdayInfoTest.java");
        fileNames.add("src/test/java/JUnit/AddressBook"+version+"/AddressBookCheckAddressBookTest.java");
        fileNames.add("src/test/java/JUnit/AddressBook"+version+"/AddressBookPrintAddressBookTest.java");
        fileNames.add("src/test/java/JUnit/AddressBook"+version+"/AddressBookEditAddressBookTest.java");
        fileNames.add("src/test/java/JUnit/AddressBook"+version+"/AddressBookEditGroupTest.java");
        fileNames.add("src/test/java/JUnit/AddressBook"+version+"/AddressBookRemoveFromGroupTest.java");
        fileNames.add("src/test/java/JUnit/AddressBook"+version+"/AddressBookRemoveGroupTest.java");
        fileNames.add("src/test/java/JUnit/AddressBook"+version+"/AddressBookRemoveAddressBookTest.java");

        fileNames.add("src/test/java/JUnit/AddressBook"+version+"/AddressBookAddMultipleAddressBookTest.java");
        fileNames.add("src/test/java/JUnit/AddressBook"+version+"/AddressBookSearchMultipleAddressBookNameTest.java");
        fileNames.add("src/test/java/JUnit/AddressBook"+version+"/AddressBookAddMultipleGroupsTest.java");
        fileNames.add("src/test/java/JUnit/AddressBook"+version+"/AddressBookAssignToMultipleGroupsTest.java");
        fileNames.add("src/test/java/JUnit/AddressBook"+version+"/AddressBookSearchByMultipleGroupsTest.java");
        fileNames.add("src/test/java/JUnit/AddressBook"+version+"/AddressBookCheckMultipleBirthdaysInfoTest.java");
        fileNames.add("src/test/java/JUnit/AddressBook"+version+"/AddressBookCheckMultipleAddressBookTest.java");
        fileNames.add("src/test/java/JUnit/AddressBook"+version+"/AddressBookPrintMultipleAddressBookTest.java");
        fileNames.add("src/test/java/JUnit/AddressBook"+version+"/AddressBookEditMultipleAddressBookTest.java");
        fileNames.add("src/test/java/JUnit/AddressBook"+version+"/AddressBookEditMultipleGroupsTest.java");
        fileNames.add("src/test/java/JUnit/AddressBook"+version+"/AddressBookRemoveFromMultipleGroupsTest.java");
        fileNames.add("src/test/java/JUnit/AddressBook"+version+"/AddressBookRemoveMultipleGroupsTest.java");
        fileNames.add("src/test/java/JUnit/AddressBook"+version+"/AddressBookRemoveMultipleAddressBookTest.java");
    }
}