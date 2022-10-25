package model.player;

import java.util.Arrays;
import model.card.Card;
import model.card.Cards;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PlayerTest {

    private Cards blackjackCards = new Cards(Arrays.asList(new Card("ACE"), new Card("QUEEN")));
    private Cards sum15Cards = new Cards(Arrays.asList(new Card("FIVE"), new Card("QUEEN")));
    private Cards sum21Cards = new Cards(Arrays.asList(new Card("FIVE"), new Card("SIX"), new Card("QUEEN")));
    private Cards sum30Cards = new Cards(Arrays.asList(new Card("QUEEN"), new Card("QUEEN"), new Card("QUEEN")));

    @Test
    void 플레이어가_버스트인_경우() {
        Player player = new Player(sum30Cards);
        Dealer dealer = new Dealer(sum30Cards);

        player.battle(dealer);
        Assertions.assertThat(player.getMoney())
            .isEqualTo(-10);
        Assertions.assertThat(dealer.getMoney())
            .isEqualTo(10);
    }

    @Test
    void 플레이어가_블랙잭이고_딜러는_블랙잭이_아닌_경우() {
        Player player = new Player(blackjackCards);
        Dealer dealer = new Dealer(sum21Cards);

        player.battle(dealer);
        Assertions.assertThat(player.getMoney())
            .isEqualTo(15);
        Assertions.assertThat(dealer.getMoney())
            .isEqualTo(-15);
    }

    @Test
    void 플레이어가_버스트가_아니고_딜러는_버스트인_경우() {
        Player player = new Player(sum15Cards);
        Dealer dealer = new Dealer(sum30Cards);

        player.battle(dealer);
        Assertions.assertThat(player.getMoney())
            .isEqualTo(10);
        Assertions.assertThat(dealer.getMoney())
            .isEqualTo(-10);
    }

    @Test
    void 둘다_버스트가_아니고_플레이어_카드합이_더큰_경우() {
        Player player = new Player(sum21Cards);
        Dealer dealer = new Dealer(sum15Cards);

        player.battle(dealer);
        Assertions.assertThat(player.getMoney())
            .isEqualTo(10);
        Assertions.assertThat(dealer.getMoney())
            .isEqualTo(-10);
    }

    @Test
    void 둘다_버스트가_아니고_딜러_카드합이_더큰_경우() {
        Player player = new Player(sum15Cards);
        Dealer dealer = new Dealer(sum21Cards);

        player.battle(dealer);
        Assertions.assertThat(player.getMoney())
            .isEqualTo(-10);
        Assertions.assertThat(dealer.getMoney())
            .isEqualTo(10);
    }
}