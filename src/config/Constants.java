package config;

/**
 * The type Constants.
 */
public class Constants {
    /**
     * The type Master.
     */
    public static class Master {
        /**
         * The constant INITIAL_MONEY.
         */
        public static final int INITIAL_MONEY = 10000;
	}

    /**
     * The type Enclosure.
     */
    public static class Enclosure {
        /**
         * The constant MAX_CLEANLINESS.
         */
        public static final int MAX_CLEANLINESS = 100;
        /**
         * The constant CLEAN_PRICE.
         */
        public static final int CLEAN_PRICE = 1000;
        /**
         * The constant FEED_PRICE.
         */
        public static final int FEED_PRICE = 1000;
        /**
         * The constant HEAL_PRICE.
         */
        public static final int HEAL_PRICE = 1000;

        /**
         * The type Aviary.
         */
        public static class Aviary {
            /**
             * The constant PRICE.
             */
            public static final int PRICE = 1000;
            /**
             * The constant SELL_PRICE.
             */
            public static final int SELL_PRICE = 500;
            /**
             * The constant SURFACE_LVL_1.
             */
            public static final int SURFACE_LVL_1 = 10;
            /**
             * The constant SURFACE_LVL_2.
             */
            public static final int SURFACE_LVL_2 = 15;
            /**
             * The constant SURFACE_LVL_3.
             */
            public static final int SURFACE_LVL_3 = 20;
            /**
             * The constant HEIGHT_LVL_1.
             */
            public static final int HEIGHT_LVL_1 = 3;
            /**
             * The constant HEIGHT_LVL_2.
             */
            public static final int HEIGHT_LVL_2 = 4;
            /**
             * The constant HEIGHT_LVL_3.
             */
            public static final int HEIGHT_LVL_3 = 5;
		}

        /**
         * The type Aquarium.
         */
        public static class Aquarium {
            /**
             * The constant PRICE.
             */
            public static final int PRICE = 1000;
            /**
             * The constant SELL_PRICE.
             */
            public static final int SELL_PRICE = 500;
            /**
             * The constant SURFACE_LVL_1.
             */
            public static final int SURFACE_LVL_1 = 10;
            /**
             * The constant SURFACE_LVL_2.
             */
            public static final int SURFACE_LVL_2 = 15;
            /**
             * The constant SURFACE_LVL_3.
             */
            public static final int SURFACE_LVL_3 = 20;
            /**
             * The constant DEPTH_LVL_1.
             */
            public static final int DEPTH_LVL_1 = 3;
            /**
             * The constant DEPTH_LVL_2.
             */
            public static final int DEPTH_LVL_2 = 4;
            /**
             * The constant DEPTH_LVL_3.
             */
            public static final int DEPTH_LVL_3 = 5;
            /**
             * The constant INITIAL_SALINITY.
             */
            public static final int INITIAL_SALINITY = 5;
		}

        /**
         * The type Terrestrial.
         */
        public static class Terrestrial {
            /**
             * The constant PRICE.
             */
            public static final int PRICE = 1000;
            /**
             * The constant SELL_PRICE.
             */
            public static final int SELL_PRICE = 500;
            /**
             * The constant SURFACE_LVL_1.
             */
            public static final int SURFACE_LVL_1 = 10;
            /**
             * The constant SURFACE_LVL_2.
             */
            public static final int SURFACE_LVL_2 = 15;
            /**
             * The constant SURFACE_LVL_3.
             */
            public static final int SURFACE_LVL_3 = 20;
		}
	}

    /**
     * The type Creature.
     */
    public static class Creature {
        /**
         * The constant MAX_STAMINA.
         */
        public static final int MAX_STAMINA = 100;
        /**
         * The constant MAX_HUNGER.
         */
        public static final int MAX_HUNGER = 100;
        
        public static final int ILLNESS_PROBABILITY = 10;
        public static final int DAILY_HUNGER_INCREASE = 10;
        public static final int MIN_SICKNESS_HP_LOSS = 10;
        public static final int MAX_SICKNESS_HP_LOSS = 30;
        public static final int DAILY_ENCLOSURE_CLEANLINESS_LOSS = 10;
        public static final int RATIO_DAILY_ENCLOSURE_CLEANLINESS_LOSS_IF_DEAD = 3;
        
        /**
         * The type Dragon.
         */
        public static class Dragon {
            /**
             * The constant ADD_PRICE.
             */
            public static final int ADD_PRICE = 1000;
            /**
             * The constant SELL_PRICE.
             */
            public static final int SELL_PRICE = 500;
            /**
             * The constant MONEY_GAIN.
             */
            public static final int MONEY_GAIN = 200;
            /**
             * The constant MAX_HP.
             */
            public static final int MAX_HP = 100;
            /**
             * The constant MAX_AGE.
             */
            public static final int MAX_AGE = 12;
            /**
             * The constant INITIAL_WEIGHT.
             */
            public static final int INITIAL_WEIGHT = 10;
            /**
             * The constant SIZE.
             */
            public static final int SIZE = 5;
            /**
             * The constant HEIGHT.
             */
            public static final int HEIGHT = 5;
		}

        /**
         * The type Kraken.
         */
        public static class Kraken {
            /**
             * The constant ADD_PRICE.
             */
            public static final int ADD_PRICE = 1000;
            /**
             * The constant SELL_PRICE.
             */
            public static final int SELL_PRICE = 500;
            /**
             * The constant MONEY_GAIN.
             */
            public static final int MONEY_GAIN = 200;
            /**
             * The constant MAX_HP.
             */
            public static final int MAX_HP = 100;
            /**
             * The constant MAX_AGE.
             */
            public static final int MAX_AGE = 12;
            /**
             * The constant INITIAL_WEIGHT.
             */
            public static final int INITIAL_WEIGHT = 10;
            /**
             * The constant SIZE.
             */
            public static final int SIZE = 5;
            /**
             * The constant HEIGHT.
             */
            public static final int HEIGHT = 3;
		}

        /**
         * The type Lycanthropes.
         */
        public static class Lycanthropes {
            /**
             * The constant ADD_PRICE.
             */
            public static final int ADD_PRICE = 1000;
            /**
             * The constant SELL_PRICE.
             */
            public static final int SELL_PRICE = 500;
            /**
             * The constant MONEY_GAIN.
             */
            public static final int MONEY_GAIN = 200;
            /**
             * The constant MAX_HP.
             */
            public static final int MAX_HP = 100;
            /**
             * The constant MAX_AGE.
             */
            public static final int MAX_AGE = 12;
            /**
             * The constant INITIAL_WEIGHT.
             */
            public static final int INITIAL_WEIGHT = 10;
            /**
             * The constant SIZE.
             */
            public static final int SIZE = 2;
		}

        /**
         * The type Megalodon.
         */
        public static class Megalodon {
            /**
             * The constant ADD_PRICE.
             */
            public static final int ADD_PRICE = 1000;
            /**
             * The constant SELL_PRICE.
             */
            public static final int SELL_PRICE = 500;
            /**
             * The constant MONEY_GAIN.
             */
            public static final int MONEY_GAIN = 200;
            /**
             * The constant MAX_HP.
             */
            public static final int MAX_HP = 100;
            /**
             * The constant MAX_AGE.
             */
            public static final int MAX_AGE = 12;
            /**
             * The constant INITIAL_WEIGHT.
             */
            public static final int INITIAL_WEIGHT = 10;
            /**
             * The constant SIZE.
             */
            public static final int SIZE = 5;
            /**
             * The constant HEIGHT.
             */
            public static final int HEIGHT = 4;
		}

        /**
         * The type Mermaid.
         */
        public static class Mermaid {
            /**
             * The constant ADD_PRICE.
             */
            public static final int ADD_PRICE = 1000;
            /**
             * The constant SELL_PRICE.
             */
            public static final int SELL_PRICE = 500;
            /**
             * The constant MONEY_GAIN.
             */
            public static final int MONEY_GAIN = 200;
            /**
             * The constant MAX_HP.
             */
            public static final int MAX_HP = 100;
            /**
             * The constant MAX_AGE.
             */
            public static final int MAX_AGE = 12;
            /**
             * The constant INITIAL_WEIGHT.
             */
            public static final int INITIAL_WEIGHT = 10;
            /**
             * The constant SIZE.
             */
            public static final int SIZE = 2;
            /**
             * The constant HEIGHT.
             */
            public static final int HEIGHT = 2;
		}

        /**
         * The type Nymph.
         */
        public static class Nymph {
            /**
             * The constant ADD_PRICE.
             */
            public static final int ADD_PRICE = 1000;
            /**
             * The constant SELL_PRICE.
             */
            public static final int SELL_PRICE = 500;
            /**
             * The constant MONEY_GAIN.
             */
            public static final int MONEY_GAIN = 200;
            /**
             * The constant MAX_HP.
             */
            public static final int MAX_HP = 100;
            /**
             * The constant MAX_AGE.
             */
            public static final int MAX_AGE = 12;
            /**
             * The constant INITIAL_WEIGHT.
             */
            public static final int INITIAL_WEIGHT = 10;
            /**
             * The constant SIZE.
             */
            public static final int SIZE = 4;
            /**
             * The constant HEIGHT.
             */
            public static final int HEIGHT = 2;
		}

        /**
         * The type Phoenix.
         */
        public static class Phoenix {
            /**
             * The constant ADD_PRICE.
             */
            public static final int ADD_PRICE = 1000;
            /**
             * The constant SELL_PRICE.
             */
            public static final int SELL_PRICE = 500;
            /**
             * The constant MONEY_GAIN.
             */
            public static final int MONEY_GAIN = 200;
            /**
             * The constant MAX_HP.
             */
            public static final int MAX_HP = 100;
            /**
             * The constant MAX_AGE.
             */
            public static final int MAX_AGE = 12;
            /**
             * The constant INITIAL_WEIGHT.
             */
            public static final int INITIAL_WEIGHT = 10;
            /**
             * The constant SIZE.
             */
            public static final int SIZE = 4;
            /**
             * The constant HEIGHT.
             */
            public static final int HEIGHT = 3;
		}

        /**
         * The type Unicorn.
         */
        public static class Unicorn {
            /**
             * The constant ADD_PRICE.
             */
            public static final int ADD_PRICE = 1000;
            /**
             * The constant SELL_PRICE.
             */
            public static final int SELL_PRICE = 500;
            /**
             * The constant MONEY_GAIN.
             */
            public static final int MONEY_GAIN = 200;
            /**
             * The constant MAX_HP.
             */
            public static final int MAX_HP = 100;
            /**
             * The constant MAX_AGE.
             */
            public static final int MAX_AGE = 12;
            /**
             * The constant INITIAL_WEIGHT.
             */
            public static final int INITIAL_WEIGHT = 10;
            /**
             * The constant SIZE.
             */
            public static final int SIZE = 2;
		}
	}
}
