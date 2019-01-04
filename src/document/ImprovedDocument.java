package document;

import java.util.List;

public class ImprovedDocument extends Document {

    public ImprovedDocument(String text)
    {
        super(text);
    }

    public int getNumWords() {
        List<String> tokens = getTokens("[a-zA-Z]+");
        //System.out.println(Arrays.toString(tokens.toArray()));
        return tokens.size();
    }


    @Override
    public int getNumSentences() {
        List<String> sentences = getTokens("[^. ]+|[^! ]+|[^? ]+");
        //System.out.println(Arrays.toString(sentences.toArray()));
        return sentences.size();
    }


    @Override
    public int getNumSyllables() {
        int numSyllables = 0;
        List<String> words = getTokens("[a-zA-Z]+");
        for(String word : words){
            numSyllables = numSyllables + getCountSyllables(word);
        }
        return numSyllables;
    }

    public static void main(String[] args) {

        testCase(new BasicDocument("This is a test.  How many???  "
                        + "Senteeeeeeeeeences are here... there should be 5!  Right?"),
                16, 13, 5);
        testCase(new BasicDocument(""), 0, 0, 0);
        testCase(new BasicDocument("sentence, with, lots, of, commas.!  "
                + "(And some poaren)).  The output is: 7.5."), 15, 11, 4);
        testCase(new BasicDocument("many???  Senteeeeeeeeeences are"), 6, 3, 2);
        testCase(new BasicDocument("Here is a series of test sentences. Your program should "
                + "find 3 sentences, 33 words, and 49 syllables. Not every word will have "
                + "the correct amount of syllables (example, for example), "
                + "but most of them will."), 49, 33, 3);
        testCase(new BasicDocument("Segue"), 2, 1, 1);
        testCase(new BasicDocument("Sentence"), 2, 1, 1);
        testCase(new BasicDocument("Sentences?!"), 3, 1, 1);
        testCase(new BasicDocument("Lorem ipsum dolor sit amet, qui ex choro quodsi moderatius, nam dolores explicari forensibus ad."),
                32, 15, 1);


    }
}
