class Solution {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> squares = new ArrayList<>();

        // Sorting
        Arrays.sort(words);

        // Iterating
        for(int i=0; i<words.length; i++){

            for(int j=0; j<words.length; j++){
                if(j==i) continue; // avoiding coincidence

                for(int k=0; k<words.length; k++){
                    if(k==j || k==i) continue;

                    for(int l=0; l<words.length; l++){
                        if(l==k ||l==j || l==i) continue;
                        // check validity
                        if(valid(words[i],words[j],words[k],words[l])){                          // add to answer
                            List<String> square = new ArrayList<>();
                            square.add(words[i]); square.add(words[j]);
                            square.add(words[k]); square.add(words[l]);
                            squares.add(square);
                        }
                    }
                }
            }
        }
        return squares;
    }

    // function to check validity : t -> top, l -> left, r -> right,b-> bottom
    private boolean valid(String t, String l, String r, String b){
        return t.charAt(0)==l.charAt(0)
            && t.charAt(3)==r.charAt(0)
            && b.charAt(0)==l.charAt(3)
            && b.charAt(3)==r.charAt(3);
    }
}