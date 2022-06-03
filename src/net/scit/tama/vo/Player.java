package net.scit.tama.vo;

public class Player {
    private String playerId;
    private String playerPwd;

    public Player() {
    }

    public Player(String playerId, String playerPwd) {
        this.playerId = playerId;
        this.playerPwd = playerPwd;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerPwd() {
        return playerPwd;
    }

    public void setPlayerPwd(String playerPwd) {
        this.playerPwd = playerPwd;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId='" + playerId + '\'' +
                ", playerPwd='" + playerPwd + '\'' +
                '}';
    }
}