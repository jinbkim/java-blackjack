package blackjack.model.player;

import blackjack.model.card.Card;
import blackjack.model.card.CardLetter;
import blackjack.model.card.CardShape;
import blackjack.model.card.Cards;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {

    private Cards burstCards;
    private Cards blackjackCards;
    private Cards sum20Cards;
    private Cards sum15Cards;
    private Cards sum12Cards;

    @BeforeEach
    void setUp() {
        burstCards = new Cards(Arrays.asList(new Card(CardLetter.KING, CardShape.CLOVER), new Card(CardLetter.KING, CardShape.CLOVER), new Card(CardLetter.KING, CardShape.CLOVER)));
        blackjackCards = new Cards(Arrays.asList(new Card(CardLetter.KING, CardShape.CLOVER), new Card(CardLetter.ACE, CardShape.CLOVER)));
        sum20Cards = new Cards(Arrays.asList(new Card(CardLetter.KING, CardShape.CLOVER), new Card(CardLetter.ACE, CardShape.CLOVER), new Card(CardLetter.KING, CardShape.CLOVER)));
        sum15Cards = new Cards(Arrays.asList(new Card(CardLetter.SEVEN, CardShape.CLOVER), new Card(CardLetter.EIGHT, CardShape.CLOVER)));
        sum12Cards = new Cards(Arrays.asList(new Card(CardLetter.ACE, CardShape.CLOVER), new Card(CardLetter.ACE, CardShape.CLOVER)));
    }

    @Test
    void 플레이어_버스트_딜러_승() {
        Player burstPlayer = new Player("버스트", 100, burstCards, GameStatus.BURST);
        Dealer burstDealer = new Dealer(burstCards, GameStatus.BURST);

        burstPlayer.calculateMoney(burstDealer);
        Assertions.assertThat(burstPlayer.isMoney(-100))
            .isTrue();
        Assertions.assertThat(burstDealer.isMoney(100))
            .isTrue();
    }

    @Test
    void 플레이어_블랙잭_플레이어_승() {
        Player blackjackPlayer = new Player("블랙잭", 100, blackjackCards, GameStatus.BLACKJACK);
        Dealer sum20Dealer = new Dealer(sum20Cards, GameStatus.DONE);

        blackjackPlayer.calculateMoney(sum20Dealer);
        Assertions.assertThat(blackjackPlayer.isMoney(150))
            .isTrue();
        Assertions.assertThat(sum20Dealer.isMoney(-150))
            .isTrue();
    }

    @Test
    void 딜러_버스트_플레이어_승() {
        Player sum20Player = new Player("승리", 100, sum20Cards, GameStatus.DONE);
        Dealer burstDealer = new Dealer(burstCards, GameStatus.BURST);

        sum20Player.calculateMoney(burstDealer);
        Assertions.assertThat(sum20Player.isMoney(100))
            .isTrue();
        Assertions.assertThat(burstDealer.isMoney(-100))
            .isTrue();
    }

    @Test
    void A_플레이어_승_B_플레이어_패() {
        Player aPlayer = new Player("승리", 100, sum20Cards, GameStatus.DONE);
        Player bPlayer = new Player("패배", 100, sum12Cards, GameStatus.DONE);
        Dealer sum15Dealer = new Dealer(sum15Cards, GameStatus.DONE);

        aPlayer.calculateMoney(sum15Dealer);
        bPlayer.calculateMoney(sum15Dealer);
        Assertions.assertThat(aPlayer.isMoney(100))
            .isTrue();
        Assertions.assertThat(bPlayer.isMoney(-100))
            .isTrue();
        Assertions.assertThat(sum15Dealer.isMoney(0))
            .isTrue();
    }
}