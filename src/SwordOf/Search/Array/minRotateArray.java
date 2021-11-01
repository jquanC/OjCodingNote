package SwordOf.Search.Array;

public class minRotateArray {
    public int minArray(int[] numbers) {
        int left = 0,right = numbers.length-1;
        int mid = left;//初始化为left,可以适应特例：当旋转0个元素，即旋转后数组整个有序时的情况；不会进入while循环

        while(numbers[left]>=numbers[right]){

            //这部分放最后面或者最前面都可以。但似乎放最前面，逻辑更清晰
            if(right == left+1){
                mid = right;
                break;
            }

            mid = (left+right)/2;//加一是不对的

            if(numbers[mid] == numbers[left] && numbers[mid]==numbers[right]){//第二个特例，无法确定目标元素是在第一个排序子数组，还是第二个排序子数组中，只能用线性探测了；e.g.原数组[0,1,1,1,1,1]
                /*这么写考虑不到只有一个元素的情况；因为不会进入循环*/
                /*for(int i = left;i<right;i++){
                    if(numbers[i]>numbers[i+1]) return numbers[i+1];
                }*/
                /*这么写*/
                int result = numbers[left];
                for(int i = left;i<right;i++){
                    if(numbers[i]<result) {
                        result = numbers[i];
                        break;
                    }
                }
                return result;
            }
            //这部分必须放在  numbers[mid] == numbers[left] && numbers[mid]==numbers[right] 的情况后面
            if(numbers[mid]>=numbers[left]){//要带=号，数组元素可重复
                //目标元素在第二个有序子数组
                left = mid;
            }else if(numbers[mid]<=numbers[right]){
                //目标元素在第一个有序子数组
                right = mid;
            }


        }

        return numbers[mid];

    }
}
