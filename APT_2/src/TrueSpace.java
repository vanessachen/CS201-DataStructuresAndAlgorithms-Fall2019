public class TrueSpace {
    public long calculateSpace(int[] sizes, int clusterSize) {
        // fill in code here
        long clustersUsed = 0;
        for (long eachSize : sizes){
            
            //long eachSpace = Math.ceil(eachSize / clusterSize);
            clustersUsed += eachSpace;
        }

        return clustersUsed*clusterSize;
    }
}