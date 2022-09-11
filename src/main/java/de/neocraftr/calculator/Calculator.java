package de.neocraftr.calculator;

import net.labymod.api.LabyModAddon;
import net.labymod.settings.elements.SettingsElement;

import java.util.List;

public class Calculator extends LabyModAddon {

    public static Calculator instance;
    public static String prefix = "§8[§9Calculator§8] §r";

    @Override
    public void onEnable() {
        instance = this;

        getApi().getEventManager().register(new ChatListener());
    }

    @Override
    public void loadConfig() {

    }

    @Override
    protected void fillSettings(List<SettingsElement> list) {

    }
}
