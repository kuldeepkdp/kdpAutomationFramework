package com.kdp.kdpAutomationFramework.navigation;

public class AssertOn {

    public static void assertOnPage(String pagename) {

        switch (pagename) {
        case "PrescribingHome": {
            System.out.println("This is prescribing home page");
            break;
        }
        case "Prescribing": {
            System.out.println("This is prescribing page");
            break;
        }

        }

    }
}
