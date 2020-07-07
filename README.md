# The-Game-of-Cribbage
JAVA code for the implementation of the Game of Cribbage

Cribbage is a very old card game, dating to early 17th century England. The game can be played by two to six (and possibly more) players. The object of the game is to be the first player to reach 121 points. Game play begins with the dealer dealing each player 4 to 6 cards (depending on how many are playing). Each player then selects four cards to keep and discards the rest. The cards discarded for all the players form an extra hand, called the crib or box, which the dealer gets to count as a bonus. Next the player preceding the dealer cuts the deck to select an extra card, called the start card.

The hand then proceeds to the play, which is outside the scope of this project, followed by the show, where each player counts the points in their hand according to the rules below, and adds the total to their running score. For this phase, the start card is usually considered as part of each player’s hand, so each player establishes the value of a 5 card hand. Points are scored for certain combinations of cards according to the following rules:

• (15s) 2 points are scored for each distinct combinations of cards that add to 15. For this purpose, an ace is counted as 1, a jack, queen or king is counted as 10, and other cards are counted as their face value. For example, a hand with a 2, 3, 5, 10, and king scores 8 points: 2 points each for 2+3+10, 2+3+king, 5+10, and 5+king.
• (Pairs) 2 points are scored for each pair. With 3 of a kind, there are 3 different ways to make a pair, so 3 of a kind scores 6 points. Similarly, 4 of a kind scores 12 points for the 6 possible pairs.
• (Runs) 1 point is scored for each card in a run of 3 or more consecutive cards (the suits of these cards need not be the same). Aces are low in cribbage, so Ace, 2, 3 is a run, but Queen, King, Ace is not. For example, a 2, 6, 8, and 9, with a 7 as the start card scores 4 points for a 4 card run. It also scores a further 6 points for 15s (6+9, 7+8, and 2+6+7).
 (Flushes) 4 points is scored if all the cards in the hand are of the same suit. 1 further point is scored if the start card is also the same suit. Note that no points are scored if 3 of the hand cards, plus the start card, are the same suit.
• (“One for his nob”) 1 point is scored if the hand contains the jack of the same suit as the start card.
