package programmers.level2.kakao;

public class 택배배달과수거하기 {
    public long solution(int cap,           //트럭 크기
                         int n,             //배달할 집 개수
                         int[] deliveries,  //
                         int[] pickups) {
        long answer = 0;
        if(isAllZero(deliveries, pickups)) return 0;

        int deliveryLastIndex = getDeliveryLastIndex(deliveries);
        int pickupLastIndex = getPickupLastIndex(pickups);
        answer += 2*(Math.max(deliveryLastIndex, pickupLastIndex)+1);

        while(deliveryLastIndex >= 0 || pickupLastIndex >=0){
            deliveryLastIndex = delivery(deliveries, cap, deliveryLastIndex);
            pickupLastIndex = pickup(pickups, cap, pickupLastIndex);
            answer += 2*(Math.max(deliveryLastIndex, pickupLastIndex)+1);
        }

        return answer;
    }

    private int getDeliveryLastIndex(int[] deliveries){
        for(int i=deliveries.length-1; i>=0; i--){
            if(deliveries[i] != 0) return i;
        }
        return 0;
    }

    private int getPickupLastIndex(int[] pickups){
        for(int i=pickups.length-1; i>=0; i--){
            if(pickups[i] != 0) return i;
        }
        return 0;
    }

    private int delivery(int[] deliveries, int cap, int lastIndex){
        for(int i=lastIndex; i>=0; i--){
            if(cap<0){
                return i;
            } else if(cap >= deliveries[i]){
                cap -= deliveries[i];
                deliveries[i] = 0;
            }else{
                deliveries[i] -= cap;
                return i;
            }
        }
        return -1;
    }

    private int pickup(int[] pickups, int cap, int lastIndex){
        for(int i=lastIndex; i>=0; i--){
            if(cap<0){
                return i;
            } else if(cap >= pickups[i]){
                cap -= pickups[i];
                pickups[i] = 0;
            }else{
                pickups[i] -= cap;
                return i;
            }
        }
        return -1;
    }

    private boolean isAllDeliveriesZero(int[] deliveries){
        for(int delivery : deliveries){
            if(delivery != 0) return false;
        }
        return true;
    }

    private boolean isAllPickupsZero(int[] pickups){
        for(int pickup : pickups){
            if(pickup != 0) return false;
        }
        return true;
    }

    private boolean isAllZero(int[] deliveries, int[] pickups){
        return isAllDeliveriesZero(deliveries) && isAllPickupsZero(pickups);
    }
}
