package xyz.bobkinn_.collectibilites;

import org.bukkit.plugin.Plugin;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CardMaker {
    public static ArrayList<Card> getCommon(Plugin plugin){
        ArrayList<Card> cards = new ArrayList<>();
        try {
            Object obj = new JSONParser().parse(new FileReader(plugin.getDataFolder()+ File.separator+"cards.json"));
            JSONObject jo = (JSONObject) obj;

            JSONArray commons = (JSONArray) jo.get("common");
            for (Object common : commons) {
                String[] loreList;
                ArrayList<String> lore = new ArrayList<>();
                JSONObject card = (JSONObject) common;
                JSONArray loreA = (JSONArray) card.get("lore");
                for (Object line : loreA){
                    lore.add(line.toString());
                }
                loreList = lore.toArray(new String[0]);

                Integer cmd = (Integer) card.get("CMD");
                cards.add(new Card(cmd, card.get("name").toString(),loreList));
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }


        return cards;
    }
}
