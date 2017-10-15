package com.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Vladislav on 01.11.2016.
 */
public class BotClient extends Client
{

    private static int botsCounter = 0;

    public static void main(String[] args)
    {
        new BotClient().run();
    }

    public class BotSocketThread extends SocketThread
    {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException
        {
            sendTextMessage("\nПривет. Я Baymax.\nПонимаю команды:\nдата\nдень\nмесяц\nгод\nвремя\nчас\nминуты\nсекунды\nшутки\nпорно\n");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message)
        {
            ConsoleHelper.writeMessage(message);

            String senderName = "";
            String senderMessageText;

            if(message.contains(": "))
            {
                senderName = message.substring(0, message.indexOf(": "));
                senderMessageText = message.substring(message.indexOf(": ") + 2);

            }
            else
            {
                senderMessageText = message;
            }

            SimpleDateFormat format = null;
            String text = null;

            if ("дата".equalsIgnoreCase(senderMessageText)) {
                format = new SimpleDateFormat("d.MM.YYYY");
            }
            else if ("день".equalsIgnoreCase(senderMessageText)) {
                format = new SimpleDateFormat("d");
            }
            else if ("месяц".equalsIgnoreCase(senderMessageText)) {
                format = new SimpleDateFormat("MMMM");
            }
            else if ("год".equalsIgnoreCase(senderMessageText)) {
                format = new SimpleDateFormat("YYYY");
            }
            else if ("время".equalsIgnoreCase(senderMessageText)) {
                format = new SimpleDateFormat("H:mm:ss");
            }
            else if ("час".equalsIgnoreCase(senderMessageText)) {
                format = new SimpleDateFormat("H");
            }
            else if ("минуты".equalsIgnoreCase(senderMessageText)) {
                format = new SimpleDateFormat("m");
            }
            else if ("секунды".equalsIgnoreCase(senderMessageText)) {
                format = new SimpleDateFormat("s");
            }
            else if("шутки".equalsIgnoreCase(senderMessageText))
            {
                /*for(int )
                * */
                text = new String("Как сказал один умный человек, не помню уже как его звали, и забыл уже, что он сказал, но мысль была хорошая.");
            }
            else if("порно".equalsIgnoreCase(senderMessageText))
            {
                /*for(int )
                * */
                text = new String("Brazzers сука смотри");
            }

            if (format != null)
            {
                sendTextMessage("Информация для " + senderName + ": " + format.format(Calendar.getInstance().getTime()));
            }
            if (text != null)
            {
                sendTextMessage("Информация для " + senderName + ":\n" + text.toString());
            }
        }
    }

    @Override
    protected SocketThread getSocketThread()
    {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSentTextFromConsole()
    {
        return false;
    }

    @Override
    protected String getUserName()
    {
        if(botsCounter == 99)
        {
            botsCounter = 0;
        }
        return "date_bot_" + botsCounter++;
    }
}
