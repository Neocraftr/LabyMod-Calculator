package de.neocraftr.calculator;

import net.labymod.api.events.MessageSendEvent;
import org.mariuszgromada.math.mxparser.Expression;

import java.text.DecimalFormat;

public class ChatListener implements MessageSendEvent {
    private DecimalFormat decimalFormat;

    public ChatListener() {
        decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumFractionDigits(340);
        decimalFormat.setMaximumIntegerDigits(340);
    }

    @Override
    public boolean onSend(String msg) {
        String[] args = msg.split(" ");
        if(args.length >= 1) {
            if(args[0].equalsIgnoreCase(".calc") || args[0].equalsIgnoreCase(".calculate")) {
                if (args.length == 2) {
                    Expression e = new Expression(args[1]);
                    if (e.checkSyntax()) {
                        String result = decimalFormat.format(e.calculate());
                        Calculator.instance.getApi().displayMessageInChat(Calculator.prefix + "§e" + args[1] + "=§a" + result);
                    } else {
                        Calculator.instance.getApi().displayMessageInChat(Calculator.prefix + "§cBitte gib eine gültige Rechenaufgabe an.");
                    }
                } else Calculator.instance.getApi().displayMessageInChat(Calculator.prefix + "§cVerwendung: .calculate <Rechenaufgabe>");
                return true;
            }
        }
        return false;
    }
}
