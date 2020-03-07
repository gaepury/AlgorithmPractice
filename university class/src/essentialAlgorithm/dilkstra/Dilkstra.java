package essentialAlgorithm.dilkstra;

import java.util.*;
 

public class Dilkstra {
 
    static int[][] ad;
    static int[] dist;
    static boolean[] visit;
    static int nE, nV;
    static final int inf = 1000000;
    
   
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        nV = scan.nextInt();
        nE = scan.nextInt();
        
        ad = new int[nV+1][nV+1]; //���� ����ġ or �Ÿ�
        dist = new int[nV+1]; //������ �ּҰŸ�
        visit = new boolean[nV+1];
        
        for(int i = 1; i <= nV; i++){
            dist[i] = inf;   //������ ������ ������ �Ÿ��� �ʱ�ȭ
        }
        
        for(int i = 0; i < nE; i++){
            int t1, t2, t3;
            t1 = scan.nextInt();
            t2 = scan.nextInt();
            t3 = scan.nextInt();
            //������ ����
            ad[t1][t2] = t3; 
            ad[t2][t1] = t3;
        }
        
        ssp(1,5);
    }
    public static void ssp(int start, int end){
        dist[start] = 0;    // ���� ���� �� distance �ʱ�ȭ
        String s = "";
        for( int j = 0; j < nV; j++) // dist ���� �ѹ� �ʱ�ȭ �����Ƿ� n-1���� ����
        {
            int min = inf+1;    // dist �ּҰ� ã�� ���� �ӽ� �� �ʱ�ȭ
            int index = -1;
            for(int k = 1; k <= nV; k++){
            	System.out.println("d["+k+"]:"+dist[k]);
                if(visit[k] == false && min > dist[k]){
                    min = dist[k];
                    index = k;
                }
            }
            System.out.println("index:"+index);
            visit[index] = true;
            s += index + " ";  // ��θ� üũ�ϴ� ���
            
            for(int l = 1; l <= nV; l++){
            	
                if(ad[index][l] != 0 && dist[l] > dist[index] + ad[index][l]){ //���� ����� �˻��Ͽ� ������ ���� ã��
                        dist[l] = dist[index] + ad[index][l];
                }
                
            }
        }
        System.out.println();
        System.out.println("���� ���");
        for(int i = 1; i <= nV; i++){
            System.out.println("d["+i+"]:"+dist[i]);
        }
        System.out.println();
        System.out.println("���� : " +s);
        
    }
 
}

