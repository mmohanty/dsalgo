package org.manas.dsalgo.interviewbit.math;

import org.manas.dsalgo.interviewbit.array.ArrayUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CityTour {

    int mod = 1000000007;

    public static void main(String[] args) {
        CityTour cityTour = new CityTour();
        List<Integer> list = ArrayUtil.toList(new int[]{3});
        int result = cityTour.solve(5, list);
        System.out.println(result);
    }


    public int solve(int A, List<Integer> B) {
        Collections.sort(B);
        List<Integer> un_vis = new ArrayList<>();
        int i=1;
        un_vis.add(B.get(0)-1);
        for(;i<B.size();i++){
            un_vis.add(B.get(i)-B.get(i-1)-1);
        }
        un_vis.add(A-B.get(i-1));
        int n = un_vis.size();
        int fact[]= new int[100000];
        fact[0] = 1;
        for(int f=1;f<100000;f++) {
            fact[f] = (f*fact[f-1])%mod;
        }
        int ans = 1,x=A-B.size(),p=1;
        for(i=0;i<n;i++){
            if(un_vis.get(i) == null){
                continue;
            }
            if(i!=0&&i!=n-1){
                ans = (ans*power(2,un_vis.get(i)-1))%mod;
            }
            p = (p*fact[un_vis.get(i)])%mod;
        }
        ans = (ans*fact[x])%mod;
        ans = (ans*power(p,mod-2))%mod;
        return ans;
        }

    int power(int x,int y){
        int res=1;
        while(y > 0){
            if((y &1) == 1){
                res = (res*x)%mod;
            }
            y>>=1;
            x = (x*x)%mod;
        }
        return res;
    }
}
