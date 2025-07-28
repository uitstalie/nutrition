package com.uitstalie.nutrition.nutrition.util.log;

import net.neoforged.neoforge.common.NeoForge;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class ChatLog {

    private int chatGap;
    private final int MAX_CHAT_GAP = 1000;
    private final BlockingQueue<Message> queue;
    private ChatLog(){
        queue = new ArrayBlockingQueue<Message>(MAX_CHAT_GAP);
        chatGap = 0;
    }

    public static class Message{
        String message;
        String tag;
    }

    private static Message inner = new Message();
    private static Message out = null;

    public static volatile ChatLog INSTANCE;

    public static ChatLog getInstance(){
        if(INSTANCE == null){
            synchronized (ChatLog.class){
                if(INSTANCE == null){
                    INSTANCE = new ChatLog();
                }
            }
        }
        return INSTANCE;
    }

    public static void chat(){
        if(INSTANCE == null){
            return;
        }
        try{
            out = INSTANCE.queue.take();
        } catch (InterruptedException e) {
            return;
        }
        if(out == null){
            return;
        }

        //show

        out = null;

    }
    public static void add(String tag,String message){
        inner.message = message;
        inner.tag = tag;
        INSTANCE.queue.add(inner);
        inner = new Message();
    }
}
