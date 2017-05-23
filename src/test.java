import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class test {
	public static void main(String[] args) {
		System.out.println("");
		int[] a=new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 29, 30, 31, 32, 33, 34, 35, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 51, 53, 54, 56, 57, 58, 60, 64, 65, 68, 72, 74, 75, 76, 77, 79, 80, 83, 84, 85, 87, 94, 95, 96, 97, 98, 99, 100, 101, 102, 105, 106, 107, 109, 111, 112, 115, 116, 120};
		int[] b=new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 29, 30, 31, 32, 33, 34, 35, 37, 38, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 51, 53, 54, 56, 57, 60, 64, 65, 68, 72, 74, 75, 76, 77, 79, 80, 83, 84, 85, 87, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 105, 106, 107, 109, 111, 112, 115, 116, 117, 120, 122};
		ArrayList aa=new ArrayList();
		ArrayList bb=new ArrayList();
		for(int i=0;i<a.length;i++){
			aa.add(a[i]);
		}
		for(int i=0;i<b.length;i++){
			bb.add(b[i]);
		}
		for(int i=0; i<aa.size();i++){
			if(Collections.binarySearch(bb, aa.get(i))>=0){
				continue;
			}else{
				System.out.println(aa.get(i));
			}
		}
		for(int i=0; i<bb.size();i++){
			if(Collections.binarySearch(aa, bb.get(i))>=0){
				continue;
			}else{
				System.out.println(bb.get(i));
			}
		}
		bb.retainAll(aa);
	}
}
