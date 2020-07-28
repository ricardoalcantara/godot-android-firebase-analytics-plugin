package ricardoalcantara.godot.plugin.godotfirebaseanalytics;


import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;

import org.godotengine.godot.Dictionary;
import org.godotengine.godot.Godot;
import org.godotengine.godot.plugin.GodotPlugin;

import java.util.Arrays;
import java.util.List;

public class GodotFirebaseAnalytics extends GodotPlugin {

    // private FirebaseAnalytics mFirebaseAnalytics;
    // private FirebaseApp mFirebaseApp;

    public GodotFirebaseAnalytics(Godot godot) {
        super(godot);
    }

    public void setCurrentScreen(final String screenName) {
        getGodot().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                FirebaseAnalytics.getInstance(getGodot()).setCurrentScreen(getGodot(), screenName, null);
                Log.d("godot", "GodotFirebaseAnalytics Setting current screen to: " + screenName);
            }
        });
    }

    public void sendAchievement(final String id) {
        getGodot().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Bundle bundle = new Bundle();
                bundle.putString(FirebaseAnalytics.Param.ACHIEVEMENT_ID, id);

                FirebaseAnalytics.getInstance(getGodot()).logEvent(FirebaseAnalytics.Event.UNLOCK_ACHIEVEMENT, bundle);

                Log.d("godot", "GodotFirebaseAnalytics Sending:AchievementUnlocked: " + id);
            }
        });
    }

    public void sendJoinGroup(final String groupID) {
        getGodot().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Bundle bundle = new Bundle();
                bundle.putString(FirebaseAnalytics.Param.GROUP_ID, groupID);

                FirebaseAnalytics.getInstance(getGodot()).logEvent(FirebaseAnalytics.Event.JOIN_GROUP, bundle);

                Log.d("godot", "GodotFirebaseAnalytics Sending:JoinGroup: " + groupID);
            }
        });
    }

    public void sendLevelUp(final String character, final int level) {
        getGodot().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Bundle bundle = new Bundle();
                bundle.putString(FirebaseAnalytics.Param.CHARACTER, character);
                bundle.putInt(FirebaseAnalytics.Param.LEVEL, level);

                FirebaseAnalytics.getInstance(getGodot()).logEvent(FirebaseAnalytics.Event.LEVEL_UP, bundle);

                Log.d("godot", "GodotFirebaseAnalytics Sending:Character:LevelUp: {" + character + "|" + level + "}");
            }
        });
    }

    public void sendScore(final String character, final int level, final int score) {
        getGodot().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Bundle bundle = new Bundle();
                bundle.putString(FirebaseAnalytics.Param.CHARACTER, character);
                bundle.putInt(FirebaseAnalytics.Param.LEVEL, level);
                bundle.putInt(FirebaseAnalytics.Param.SCORE, score);

                FirebaseAnalytics.getInstance(getGodot()).logEvent(FirebaseAnalytics.Event.POST_SCORE, bundle);

                Log.d("godot", "GodotFirebaseAnalytics Sending:Level:Score: {" + character + "|" + level + "|" + score + "}");
            }
        });
    }

    public void sendSelectContent(final String contentType, final String itemId) {
        getGodot().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Bundle bundle = new Bundle();
                bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, contentType);
                bundle.putString(FirebaseAnalytics.Param.ITEM_ID, itemId);

                FirebaseAnalytics.getInstance(getGodot()).logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);

                Log.d("godot", "GodotFirebaseAnalytics Sending:Content:Item: {" + contentType + "|" + itemId + "}");
            }
        });
    }

    public void sendEarnVirtualCurrency(final String currencyName, final int value) {
        getGodot().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Bundle bundle = new Bundle();
                bundle.putString(FirebaseAnalytics.Param.VIRTUAL_CURRENCY_NAME, currencyName);
                bundle.putInt(FirebaseAnalytics.Param.VALUE, value);

                FirebaseAnalytics.getInstance(getGodot()).logEvent(FirebaseAnalytics.Event.EARN_VIRTUAL_CURRENCY, bundle);

                Log.d("godot", "GodotFirebaseAnalytics Sending:Currency:Earn: {" + currencyName + "|" + value + "}");
            }
        });
    }

    public void sendSpendVirtualCurrency(final String itemName, final String currencyName, final int value) {
        getGodot().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Bundle bundle = new Bundle();
                bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, itemName);
                bundle.putString(FirebaseAnalytics.Param.VIRTUAL_CURRENCY_NAME, currencyName);
                bundle.putInt(FirebaseAnalytics.Param.VALUE, value);

                FirebaseAnalytics.getInstance(getGodot()).logEvent(FirebaseAnalytics.Event.SPEND_VIRTUAL_CURRENCY, bundle);

                Log.d("godot",
                        "GodotFirebaseAnalytics Sending:Currency:Spend: {" + itemName + "|" + currencyName + "|" + value + "}");
            }
        });
    }

    public void sendTutorialBegin() {
        getGodot().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Bundle bundle = new Bundle();
                FirebaseAnalytics.getInstance(getGodot()).logEvent(FirebaseAnalytics.Event.TUTORIAL_BEGIN, bundle);

                Log.d("godot", "GodotFirebaseAnalytics Sending:Tutorial:Begin");
            }
        });
    }

    public void sendTutorialComplete() {
        getGodot().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Bundle bundle = new Bundle();
                FirebaseAnalytics.getInstance(getGodot()).logEvent(FirebaseAnalytics.Event.TUTORIAL_COMPLETE, bundle);

                Log.d("godot", "GodotFirebaseAnalytics Sending:Tutorial:Complete");
            }
        });
    }

    public void sendEvents(final String eventName, final Dictionary keyValues) {
        getGodot().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Bundle bundle = new Bundle();
                putAllInDict(bundle, keyValues);

                FirebaseAnalytics.getInstance(getGodot()).logEvent(eventName, bundle);

                Log.d("godot", "GodotFirebaseAnalytics Sending:App:Event:[" + eventName + "]:" + bundle.toString() + "");
            }
        });
    }

    public void sendCustom(final String key, final String value) {

        getGodot().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Bundle bundle = new Bundle();
                bundle.putString(key, value);

                FirebaseAnalytics.getInstance(getGodot()).logEvent("appEvent", bundle);
                Log.d("godot", "GodotFirebaseAnalytics Sending:App:Event:" + bundle.toString());
            }
        });
    }

    private void putAllInDict(Bundle bundle, Dictionary keyValues) {
        String[] keys = keyValues.get_keys();
        for (int i = 0; i < keys.length; i++) {
            String key = keys[i];
            putGodotValue(bundle, key, keyValues.get(key));
        }
    }

    private void putGodotValue(Bundle bundle, String key, Object value) {
        if (value instanceof Boolean) {
            bundle.putBoolean(key, (Boolean) value);
        } else if (value instanceof Integer) {
            bundle.putInt(key, (Integer) value);
        } else if (value instanceof Double) {
            bundle.putDouble(key, (Double) value);
        } else if (value instanceof String) {
            bundle.putString(key, (String) value);
        } else {
            if (value != null) {
                bundle.putString(key, value.toString());
            }
        }
    }

    @NonNull
    @Override
    public String getPluginName() {
        return "GodotFirebaseAnalytics";
    }

    @NonNull
    @Override
    public List<String> getPluginMethods() {
        return Arrays.asList("setCurrentScreen","sendAchievement","sendJoinGroup","sendLevelUp","sendScore","sendSelectContent","sendEarnVirtualCurrency","sendSpendVirtualCurrency","sendTutorialBegin","sendTutorialComplete","sendEvents","sendCustom");
    }
}
