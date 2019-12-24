
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import model.HeadHunter;
import model.Vacancy;

public class Bot extends TelegramLongPollingBot {

	public void onUpdateReceived(Update update) {
		HeadHunter hh = new HeadHunter();
		String chatId = update.getMessage().getChatId().toString();
		StringBuilder message = new StringBuilder();
		for (Vacancy v : hh.getVacancies()) {
			message.append(v + "\n\n");
		}
		sndMessage(chatId, message.toString());
	}

	public void sndMessage(String chatId, String text) {
		SendMessage send = new SendMessage();
		send.setChatId(chatId);
		send.setText(text);
		send.enableMarkdown(true);
		try {
			execute(send);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	public String getBotUsername() {
		return "JuniorVacancyBot";
	}

	@Override
	public String getBotToken() {
		return "1014937171:AAHsCL6aSu7v6RTua_j-rQWLZkF6hwAE9uA";
	}
}
