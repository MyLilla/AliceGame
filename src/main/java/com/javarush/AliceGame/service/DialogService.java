package com.javarush.AliceGame.service;

import com.javarush.AliceGame.dates.Dialog;
import com.javarush.AliceGame.dates.Personage;
import com.javarush.AliceGame.dates.Room;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class DialogService {

    protected static final Logger LOGGER = LogManager.getLogger(DialogService.class);
    private final ArrayList<Dialog> dialogs;

    public DialogService(ArrayList<Dialog> dialogs) {
        this.dialogs = dialogs;
        LOGGER.debug("DialogService created");
    }

    public Dialog.Message getMessage(Personage personage, String nextMessage) {

        int nextQuestionId = Integer.parseInt(nextMessage);
        LOGGER.info("nextQuestionId: {}", nextQuestionId);

        List<Dialog.Message> messages = dialogs.get(personage.getId()).getMessages();

        return messages.get(nextQuestionId);
    }
}
