package com.kdp.kdpAutomationFramework.navigation;

public class Navigate {

    public static void navigateToPage(String pagename) {

        switch (pagename) {
        case "PrescribingHome": {
            System.out.println("Let's play Hockey");
            break;
        }
        case "Prescribing": {
            System.out.println("Let's play Cricket");
            break;
        }

        }

    }

}
