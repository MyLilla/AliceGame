package com.javarush.AliceGame.service;

import com.javarush.AliceGame.dates.Dialog;
import com.javarush.AliceGame.dates.Personage;
import com.javarush.AliceGame.exceptions.DialogException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DialogServiceTest {

    @Mock
    Personage personage;
    @Mock
    Dialog dialog;
    @Spy
    ArrayList<Dialog> dialogs;
    @Mock
    DialogService dialogService;

    @BeforeEach
    void setup() {
        dialog = Dialog.builder()
                .messages(List.of(Dialog.Message.builder()
                        .id(0)
                        .text("Message text")
                        .answers(List.of(Dialog.Answer.builder()
                                .text("Answer text").
                                nextQuestion(1).build())).build())).build();
        dialogs.add(dialog);
        dialogService = new DialogService(dialogs);
    }

    @Test
    void getMessageTest_whenNextMessageIsNullOrEmpty() {
        assertThrows(DialogException.class,
                () -> dialogService.getMessage(personage, null));
    }

    @Test
    void getMessageTest() {
        Dialog.Message expected = Dialog.Message.builder()
                .id(0)
                .text("Message text")
                .answers(List.of(Dialog.Answer.builder()
                        .text("Answer text").
                        nextQuestion(1).build())).build();
        assertEquals(expected, dialogService.getMessage(personage, "0"));
    }

    @Test
    void getDialogsTest_positive() {
        assertEquals(dialogs, dialogService.getDialogs());
    }
}
