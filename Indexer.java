package solr;

import java.io.Serializable;
import java.util.*;


public class Indexer implements Serializable {

//    private int

    static final long serialVersionUID = 1L;

    private Map<String, Set<Integer>> invertedIndexes = new HashMap<String, Set<Integer>>();

    private List<String> docIdDataMapping = new ArrayList<String>();

    Indexer()
    {

    }

    public Map<String, Set<Integer>> getInvertedIndexes() {
        return invertedIndexes;
    }

    public String getDocFromId(int id)
    {
        return docIdDataMapping.get(id);
    }

    public Set<Integer> getDocsForTerm(String term)
    {
        if( invertedIndexes.get(term) != null )
            return invertedIndexes.get(term);
        else
            return new LinkedHashSet<Integer>();
    }

    public void addInvIndex(String term, int docId){
        if(invertedIndexes.get(term) != null)
        {
            Set<Integer> list = invertedIndexes.get(term);
            list.add(docId);
            invertedIndexes.put(term, list);
        }
        else
        {
            Set<Integer> list = new LinkedHashSet<Integer>();
            list.add(docId);
            invertedIndexes.put(term, list);
        }

    }

    public int addDoc(String data)
    {
        this.docIdDataMapping.add(data);
        return docIdDataMapping.size() - 1;
    }

}
