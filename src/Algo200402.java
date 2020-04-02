import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/*
 * 해쉬
 * Key-value쌍으로 데이터를 저장하는 자료구조
 */
public class Algo200402 {
	public static void main(String[] args) {
		
		unfinishedPlayer(); // 문제 1
		
		phoneNumberList(); // 문제 2
		
		camouflage(); // 문제 3
		
		bestAlbum(); // 문제 4
	}
	
	/*
	 * 문제1
	 * 완주하지 못한 선수
	 */
	public static void unfinishedPlayer() {
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		
		int count = 0;
        HashSet<String> participantSet = new HashSet<String>(Arrays.asList(participant));
        HashSet<String> completionSet = new HashSet<String>(Arrays.asList(completion));
        
        if(participantSet.size() == completionSet.size()) {
            Arrays.sort(participant);
            Arrays.sort(completion);

            for(String cmp : completion) {
                if(!cmp.equals(participant[count])) System.out.println("문제1.완주하지 못한 선수 : " + participant[count]);
                count++;
            }
        } else {
            for(String prt : participantSet) {
                if(!completionSet.contains(prt)) System.out.println("문제1.완주하지 못한 선수 : " + prt);
            }
        }
	}
	
	/*
	 * 문제2
	 * 전화번호 목록
	 */
	public static void phoneNumberList() {
		String[] phone_book = {"119", "97674223", "1195524421"};
		boolean answer = true;
        
        for(String prefix : phone_book) {
            for(String num : phone_book) {
                if(prefix.length() < num.length()) {
                    if(prefix.equals(num.substring(0, prefix.length()))) {
                    	answer = false;
                    	break;
                    }
                }
                if(answer == false) break;
            }
        }
        
        System.out.println("문제2.전화번호 목록 : " + answer);
	}
	
	/*
	 * 문제3
	 * 위장
	 */
	public static void camouflage() {
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int answer = 0;
        int multiple = 1;
        
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for(int i = 0; i < clothes.length; i++) {
            hm.put(clothes[i][1], hm.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        for(int count : hm.values()) {
            multiple *= (count+1);
        }
        answer = multiple-1;
        
        System.out.println("문제3.위장 : " + answer);
	}
	
	/*
	 * 문제4
	 * 베스트앨범
	 */
	public static void bestAlbum() {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		int[] answers = {};

        Map<String, Integer> sum = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            sum.put(genres[i], sum.getOrDefault(genres[i], 0)+plays[i]);
        }
        
        List<String> sortedGenres = new ArrayList<>();
        sum.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .forEach(x -> sortedGenres.add(x.getKey()));
        
        List<Integer> sortedSongs = new ArrayList<>();
        for(String genre : sortedGenres) {
            Map<Integer,Integer> songs = new HashMap<>();
            for(int i = 0; i < genres.length; i++) {
                if(genre.equals(genres[i])) {
                    songs.put(i, plays[i]);
                }
            }
            songs.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(2).forEach(x -> sortedSongs.add(x.getKey()));
        }
        
        answers = sortedSongs.stream().mapToInt(Integer::intValue).toArray();
        
        for(int answer : answers) {
        	System.out.println("문제4.베스트앨범 : " + answer);
        }
	}
}
