public class PairDown {
    public int[] fold(int[] list){
        int numPairs = (list.length+1)/2; //this is to account for the odd values of list length bc of integer division
        int[] pairArray = new int[numPairs]; //create a new int array of size numPairs
        for (int i=0; i < list.length; i+=2){//increment i by 2 because you are going through by pairs
            int oddOffset = 0;
            if (i+1 < list.length){
                oddOffset = list[i+1]; //our offset is set to the next pair to the right
            }
            pairArray[i/2] = list[i] + oddOffset; //note that oddOffset will still be 0 if i+1>= listlength

        }
        return pairArray;
    }
}
