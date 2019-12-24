package model;

public class Vacancy {
	private String title;
	private String company;
	private String date;
	private String salary;
	private String url;

	public String getTitle() {
		return title;
	}

	public String getCompany() {
		return company;
	}

	public String getDate() {
		return date;
	}

	public String getSalary() {
		return salary;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Вакансия: " + title + 
				"\nКомпания: " + company +
				"\nДата публикации: " + date + 
				"\nЗарплата: " + salary +
				"\nСсылка: " + url;
	}
	
	
}
