//https://www2.cs.duke.edu/csed/newapt/dnamax.html

public class DNAMaxNucleotide {
    public String max(String[] strands, String nuc) {
        // max number of nucleotides found so far
        int maxNumber = 0;

        // string with max number of nucleotides "nuc" found so far
        String maxString = "";

        // convert nucleotide string to a character (at index 0)
        char nucleotide = nuc.charAt(0);

        //for each DNA strand do the following
        for (String eachString : strands){
            // for each string, count number of nuc's
            int nucNum = count(eachString, nucleotide);

            //if the nucNum found is greater than the current max (maxNumber) then set max equal to current nucNum maxString to current string
            if (nucNum > maxNumber) {
                maxNumber = nucNum;
                maxString = eachString;
            }
            //if the nucNum found is equal to the current max (maxNumber) & the length is greater, then set max equal to current nucNum & maxString to current string
            else if ((nucNum == maxNumber) && (maxString.length() < eachString.length()) && (nucNum > 0)){
                //maxNumber = nucNum;
                maxString = eachString;
            }
            else {
               //nothing
             }
            //find which string in strands has the max number; if more than one has the longest, then return the longest strang
        }
       return maxString;
    }

    // can write other methods in the same class.
    // count returns the number of a particular nucleotide in a dna string
    public int count(String dna, char nucleotide)
    {
        int countOfNucleotide = 0;    //create and initialize variable to store count

        //for each character (tempNuc) in string dna
        for (char tempNuc : dna.toCharArray()) {
            //if the character in dna is equal to our "nuc" of interest
            if (tempNuc == nucleotide) {
                countOfNucleotide++;
            }
        }
        return countOfNucleotide;
    }
}
