package contract.Entity;

public interface IHero {

    int getScore();

    boolean getPlaying();

    boolean getIsAlive();

    String getEtat();


    void setScore(int score) ;

    void setPlaying(boolean playing) ;

    void setIsAlive(boolean isAlive) ;

    void setEtat(String etat);

    void attente() ;


}
