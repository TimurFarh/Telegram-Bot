package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HeadHunter {
	private static final String URL_FORMAT = "https://ekaterinburg.hh.ru/search/vacancy?area=1261&st=searchVacancy&text=Java+junior&page=%d";

	public List<Vacancy> getVacancies() {
		List<Vacancy> vacancies = new ArrayList<>();
		Document document;
		for (int page = 0;; page++) {
			document = getDocument(page);
			Elements elements = document.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
			if (elements.size() == 0) break;
			for (Element e : elements) {
				Vacancy vacancy = new Vacancy();
				vacancy.setTitle(e.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").text());
				vacancy.setCompany(e.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer").text());
				vacancy.setDate(e.getElementsByClass("vacancy-serp-item__publication-date").text());
				vacancy.setSalary(e.getElementsByClass("vacancy-serp-item__compensation").text());
				vacancy.setUrl(e.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").attr("href"));
				vacancies.add(vacancy);
			}
		}
		return vacancies;
	}

	public Document getDocument(int page) {
		try {
			return Jsoup.connect(String.format(URL_FORMAT, page)).get();
		} catch (IOException e) {
			return null;
		}
	}

}
