/**
 * This program is to evaluate a hand for the game of Cribbage. This
 * program receives 5 cards on the command line and will print out the number of
 * points the hand comprising the first four of those cards would score if the
 * fifth card were the start card.
 */

public class HandValue {

	private static int sumNum = 0;

	// the input of the card
	static class MyCard {
		private Suit suit;
		private CribbageRank rank;

		public Suit getSuit() {
			return suit;
		}

		public void setSuit(Suit suit) {
			this.suit = suit;
		}

		public CribbageRank getRank() {
			return rank;
		}

		public void setRank(CribbageRank rank) {
			this.rank = rank;
		}

	}

	/**
	 * A simple main method to calculate the total value of a hand and print it out.
	 */
	public static void main(String[] args) {
		MyCard[] c = new MyCard[5];
		c = getCard(args);
		MyCard[][] cc = Combinations.combinations(c); // make the combination of all the cards
		MyCard[][] ccs = cardSort(cc); // make a sort of the combination

		sumNum += a15Num(cc) * 2;
		sumNum += numberPairs(cc) * 2;

		if (runNum(ccs)[2] > 0) {
			sumNum += runNum(ccs)[2] * 5;
		} else if (runNum(ccs)[0] > 0) {
			sumNum += runNum(ccs)[0] * 4;
		} else {
			sumNum += runNum(ccs)[1] * 3;
		}

		if (flushNum(c)[0] > 0) {
			sumNum += flushNum(c)[0] * 5;
		} else {
			sumNum += flushNum(c)[1] * 4;
		}

		sumNum += nobNum(c);
		System.out.println(sumNum); // print out the number of points
	}

	// sort the combination by rank
	private static MyCard[][] cardSort(MyCard[][] ccb) {
		MyCard[][] cc2 = ccb;
		for (int m = 0; m < cc2.length; m++) {
			for (int n = 0; n < cc2[m].length - 1; n++) {
				for (int k = 0; k < cc2[m].length - 1 - n; k++) {
					if (cc2[m][k].getRank().ordinal() > cc2[m][k + 1].getRank().ordinal()) {
						MyCard isk = cc2[m][k];
						cc2[m][k] = cc2[m][k + 1];
						cc2[m][k + 1] = isk;
					}
				}
			}
		}
		return cc2;
	}

	/** @return the number of 15s */
	private static int a15Num(MyCard[][] cc) {
		int zuihoufenshu15s = 0;
		for (int m = 0; m < cc.length; m++) {
			int qiuhe = 0;
			for (int n = 0; n < cc[m].length; n++) {
				qiuhe += cc[m][n].getRank().faceValue();
			}
			if (qiuhe == 15) {
				zuihoufenshu15s += 1;
			}
		}
		return zuihoufenshu15s;
	}

	/** @return the number of pairs */
	private static int numberPairs(MyCard[][] cc) {

		int pairs4 = 0;
		int pairs3 = 0;
		int pairs2 = 0;

		for (int m = 0; m < cc.length; m++) {
			if (cc[m].length == 4) {
				if (cc[m][0].getRank().equals(cc[m][1].getRank()) && cc[m][0].getRank().equals(cc[m][2].getRank())
						&& cc[m][0].getRank().equals(cc[m][3].getRank())) {
					pairs4++;

				}
			}
			if (cc[m].length == 3) {
				if (cc[m][0].getRank().equals(cc[m][1].getRank()) && cc[m][0].getRank().equals(cc[m][2].getRank())) {
					pairs3++;

				}
			}
			if (cc[m].length == 2) {
				if (cc[m][0].getRank().equals(cc[m][1].getRank())) {
					pairs2++;

				}
			}
		}
		return pairs2;
	}

	/** @return the number of runs */
	private static int[] runNum(MyCard[][] cardComb) {
		int fivePairs = 0;
		int fourPairs = 0;
		int threePairs = 0;
		int twoPairs = 0;
		for (int m = 0; m < cardComb.length; m++) {//
			if (cardComb[m].length == 5) {
				if (cardComb[m][0].getRank().nextHigher() != null
						&& cardComb[m][1].getRank().nextHigher() != null
						&& cardComb[m][2].getRank().nextHigher() != null
						&& cardComb[m][3].getRank().nextHigher() != null) {
					if ((cardComb[m][0].getRank().nextHigher().equals(cardComb[m][1].getRank())
							&& cardComb[m][1].getRank().nextHigher().equals(cardComb[m][2].getRank())
							&& cardComb[m][2].getRank().nextHigher().equals(cardComb[m][3].getRank())
							&& cardComb[m][3].getRank().nextHigher().equals(cardComb[m][4].getRank()))) {
						fivePairs++;
					}
				}
			}
			if (cardComb[m].length == 4) {
				if (cardComb[m][0].getRank().nextHigher() != null
						&& cardComb[m][1].getRank().nextHigher() != null
						&& cardComb[m][2].getRank().nextHigher() != null) {

					if ((cardComb[m][0].getRank().nextHigher().equals(cardComb[m][1].getRank())
							&& cardComb[m][1].getRank().nextHigher().equals(cardComb[m][2].getRank())
							&& cardComb[m][2].getRank().nextHigher().equals(cardComb[m][3].getRank()))) {
						fourPairs++;
						// return 4;
					}
				}
			}
			if (cardComb[m].length == 3) {
				if (cardComb[m][0].getRank().nextHigher() != null
						&& cardComb[m][1].getRank().nextHigher() != null) {

					if (cardComb[m][0].getRank().nextHigher().equals(cardComb[m][1].getRank())
							&& cardComb[m][1].getRank().nextHigher().equals(cardComb[m][2].getRank())) {
						threePairs++;
					}
				}
			}

		}
		int[] i = new int[3];
		i[0] = fourPairs;
		i[1] = threePairs;
		i[2] = fivePairs;
		return i;
	}

	/** @return the number of flushes */
	private static int[] flushNum(MyCard[] cards) {
		int[] flush = new int[2];
		if (cards[0].getSuit().equals(cards[1].getSuit()) && cards[0].getSuit().equals(cards[2].getSuit())
				&& cards[0].getSuit().equals(cards[3].getSuit()) && cards[0].getSuit().equals(cards[4].getSuit())) {
			flush[0] = 1;
			flush[1] = 0;
			return flush;
		} else if (cards[0].getSuit().equals(cards[1].getSuit()) && cards[0].getSuit().equals(cards[2].getSuit())
				&& cards[0].getSuit().equals(cards[3].getSuit())) {
			flush[0] = 0;
			flush[1] = 1;
			return flush;
		}
		return flush;
	}

	/** @return the number of "one for his nob" */
	private static int nobNum(MyCard[] cards) {
		int nobPoints = 0;
		for (int m = 0; m < cards.length - 1; m++) {
			if (cards[m].getRank().equals(CribbageRank.JACK)
					&& cards[m].getSuit().equals(cards[cards.length - 1].getSuit())) {
				nobPoints++;
			}
		}
		return nobPoints;
	}

	/** @return the points of each card */
	private static MyCard[] getCard(String[] args) {
		MyCard[] cards = new MyCard[5];
		for (int i = 0; i < args.length; i++) {
			MyCard c = new MyCard();
			String string = args[i];
			char s = string.charAt(0);
			char r = string.charAt(1);
			switch (s) {
			case 'A':
				c.setRank(CribbageRank.ACE);
				break;
			case '2':
				c.setRank(CribbageRank.TWO);
				break;
			case '3':
				c.setRank(CribbageRank.THREE);
				break;
			case '4':
				c.setRank(CribbageRank.FOUR);
				break;
			case '5':
				c.setRank(CribbageRank.FIVE);
				break;
			case '6':
				c.setRank(CribbageRank.SIX);
				break;
			case '7':
				c.setRank(CribbageRank.SEVEN);
				break;
			case '8':
				c.setRank(CribbageRank.EIGHT);
				break;
			case '9':
				c.setRank(CribbageRank.NINE);
				break;
			case 'T':
				c.setRank(CribbageRank.TEN);
				break;
			case 'J':
				c.setRank(CribbageRank.JACK);
				break;
			case 'Q':
				c.setRank(CribbageRank.QUEEN);
				break;
			case 'K':
				c.setRank(CribbageRank.KING);
				break;
			default:
				c.setRank(CribbageRank.KING);
			}
			switch (r) {
			case 'C':
				c.setSuit(Suit.CLUBS);
				break;
			case 'D':
				c.setSuit(Suit.DIAMONDS);
				break;
			case 'H':
				c.setSuit(Suit.HEARTS);
				break;
			case 'S':
				c.setSuit(Suit.SPADES);
				break;
			default:
				c.setSuit(Suit.SPADES);
			}

			cards[i] = c;
		}
		return cards;
	}

	// the class of the card
	public enum Suit {
		CLUBS('c'), DIAMONDS('d'), HEARTS('h'), SPADES('s');

		private final char out;

		public char abbrev() {
			return out;
		}

		Suit(char out) {
			this.out = out;
		}
	}
}
