
public class DustinProof5
{
    private int numPosCases = 0;
    int varA;
    int varB;
    
    public int testProof(){
        int i = 1;
        int j = 0;
        for(i=1; i<=200; ++i){
            varA = 2*i;
            //System.out.println(varA);
            while(j<199){
                varB = 2*j + 1;
                //System.out.println(varB);
                if((Math.pow(varA,2) + 2 * Math.pow(varB,2)) % 4 == 0){
                    ++numPosCases;
                }
                ++j;
            }
            j=0;
        }
        return numPosCases;
    }
    
    
}
