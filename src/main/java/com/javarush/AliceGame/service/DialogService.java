package com.javarush.AliceGame.service;

import com.javarush.AliceGame.dates.Dialog;
import com.javarush.AliceGame.dates.Personage;
import com.javarush.AliceGame.exceptions.DialogException;
import lombok.Getter;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DialogService {

    protected static final Logger LOGGER = LogManager.getLogger(DialogService.class);
    private final ArrayList<Dialog> dialogs;

    public DialogService(ArrayList<Dialog> dialogs) {
        this.dialogs = dialogs;
        LOGGER.debug("DialogService created");
    }

    public Dialog.Message getMessage(Personage personage, String nextMessage) {

        if (ObjectUtils.isEmpty(nextMessage)) {
            LOGGER.error("Next message is empty or null");
            throw new DialogException("NextMessage can't be empty or null");
        }
        int nextQuestionId = Integer.parseInt(nextMessage);
        LOGGER.info("nextQuestionId: {}", nextQuestionId);

        List<Dialog.Message> messages = dialogs.get(personage.getId()).getMessages();

        return messages.get(nextQuestionId);
    }
}
