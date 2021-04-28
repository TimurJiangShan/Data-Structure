public class SerializeDeserializeNaryTree {
    public:
    void dfs(DirectedGraphNode* root,string & ans) {
        if(root == NULL)
            return ;
        ans += "[";
        ans += to_string(root->label);
        for(int i = 0; i < root->neighbors.size() ; i++) {
            dfs(root->neighbors[i],ans);
        }
        ans += "]";

    }
    UndirectedGraphNode * solve(string& data,int &pos) {
        int num = 0;
        while(data[pos] >= '0' && data[pos] <= '9') {
            num *= 10;
            num += data[pos] - '0';
            pos++;
        }
        UndirectedGraphNode * node =  new UndirectedGraphNode(num);
        while(pos<data.length()) {
            if(data[pos] == '[' )
                node->neighbors.push_back(solve(data,++pos));
            else if(data[pos] == ']') {
                pos++;
                return node;
            }
        }
    }
    string serialize(vector<DirectedGraphNode*> &nodes) {
        string ans;
        if(nodes.size() == 0)
            return ans;
        dfs(nodes[0],ans);
        return ans;
    }
    UndirectedGraphNode * deserialize(string &data) {
        if(data.length() == 0)
            return NULL;
        int pos = 1;
        return solve(data,pos);
    }
}
