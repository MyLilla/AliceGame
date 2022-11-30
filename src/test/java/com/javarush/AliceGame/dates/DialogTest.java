package com.javarush.AliceGame.dates;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DialogTest {

    @Test
    void equalsAndHashCodeContract_Dialog() {
        EqualsVerifier.simple()
                .forClass(Dialog.class)
                .suppress(Warning.INHERITED_DIRECTLY_FROM_OBJECT)
                .verify();
    }

    @Test
    void equalsAndHashCodeContract_Message() {
        EqualsVerifier.simple()
                .forClass(Dialog.Message.class)
                .suppress(Warning.INHERITED_DIRECTLY_FROM_OBJECT)
                .verify();
    }

    @Test
    void equalsAndHashCodeContract_Answer() {
        EqualsVerifier.simple()
                .forClass(Dialog.Answer.class)
                .suppress(Warning.INHERITED_DIRECTLY_FROM_OBJECT)
                .verify();
    }
}