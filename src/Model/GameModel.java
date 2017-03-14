package Model;

/**
 * Created by jasper wil.lankhorst on 20-12-2016.
 */
public interface GameModel {

    //ingame Moves.
    void sendMove(int move); //send a move to server.
    void sendWin(); //send win to server. (server checks if Human won or not.)
    void sendPM(String message, String Player); //sends a randomchat.

    //Duel request //Host moves.
    void requestDuel(String playerName, String game); //request a duel from client to playername.
    void acceptDuel(String duelRequestName); //Accept duelrequest from client to Human X. -> Starts the game at both ends?
    void cancelRequestDuel(String duelRequestName); //cancel duelrequest from client to Human X.

    //extra functions.
    String help(); //gives rules / information about the current game.
    void quit(); //removes module from the board , returning to mainscreen.
    String status(String playerName); //sends current status of the Human to other people.
}