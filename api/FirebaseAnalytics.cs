using Godot;
using Godot.Collections;

public class FirebaseAnalytics : Node
{
    private Godot.Object _firebaseAnalytics = null;

    public override void _Ready()
    {
        if (Engine.HasSingleton("GodotFirebaseAnalytics"))
        {
            GD.Print("GodotFirebaseAnalytics HasSingleton");
            _firebaseAnalytics = Engine.GetSingleton("GodotFirebaseAnalytics");
        }
        else
        {
            GD.Print("GodotFirebaseAnalytics is not available");
        }
    }

    public void SetCurrentScreen(string screenName) => _firebaseAnalytics?.Call("setCurrentScreen", screenName);
    public void SendAchievement(string id) => _firebaseAnalytics?.Call("sendAchievement", id);
    public void SendJoinGroup(string groupID) => _firebaseAnalytics?.Call("sendJoinGroup", groupID);
    public void SendLevelUp(string character, int level) => _firebaseAnalytics?.Call("sendLevelUp", character, level);
    public void SendScore(string character, int level, int score) => _firebaseAnalytics?.Call("sendScore", character, level, score);
    public void SendSelectContent(string contentType, string itemId) => _firebaseAnalytics?.Call("sendSelectContent", contentType, itemId);
    public void SendEarnVirtualCurrency(string currencyName, int value) => _firebaseAnalytics?.Call("sendEarnVirtualCurrency", currencyName, value);
    public void SendSpendVirtualCurrency(string itemName, string currencyName, int value) => _firebaseAnalytics?.Call("sendSpendVirtualCurrency", itemName, currencyName, value);
    public void SendTutorialBegin() => _firebaseAnalytics?.Call("sendTutorialBegin");
    public void SendTutorialComplete() => _firebaseAnalytics?.Call("sendTutorialComplete");
    public void SendEvents(string eventName, Dictionary keyValues) => _firebaseAnalytics?.Call("sendEvents", eventName, keyValues);
    public void SendCustom(string key, string value) => _firebaseAnalytics?.Call("sendCustom", key, value);
}
