package com.kdp.kdpAutomationFramework.pages;

public class Page {
	
	public static String currentPage;

	public static String getCurrentPage() {
		return currentPage;
	}

	public static void setCurrentPage(String currentPage) {
		Page.currentPage = currentPage;
	}
	
}
