public class ThreeEqualParts {
    public:
    vector<int> result;
    vector<int> threeEqualParts(vector<int>& A)
    {
        int oneSum = 0;
        for(auto d:A)
        {
            if(d==1)
                oneSum ++;
        }

        if(oneSum==0)
        {
            result.push_back(0);
            result.push_back(A.size()-1);
            return result;
        }

        if(oneSum % 3 != 0)
        {
            result.push_back(-1);
            result.push_back(-1);
            return result;
        }

        int tmpOneSum = 0;
        int i;
        for(i = A.size()-1; i >= 0; i --)
        {
            if(A[i]==1)
                tmpOneSum ++;
            if(tmpOneSum == oneSum/3)
            {
                break;
            }
        }

        vector<int> part3;
        for(; i < A.size(); i ++)
            part3.push_back(A[i]);

        for(i = 0; A[i]==0; i ++)
            ;
        int part3End = 0;

        for(int j = i; i-j < part3.size(); i ++)
        {
            if(A[i]!=part3[part3End++])
            {
                result.push_back(-1);
                result.push_back(-1);
                return result;
            }
        }

        int resultPart = i-1;
        for(; A[i]==0; i ++)
            ;

        part3End = 0;
        for(int j = i; i-j < part3.size(); i ++)
        {
            if(A[i]!=part3[part3End++])
            {
                result.push_back(-1);
                result.push_back(-1);
                return result;
            }
        }

        result.push_back(resultPart);
        result.push_back(i);

        return result;
    }
}
