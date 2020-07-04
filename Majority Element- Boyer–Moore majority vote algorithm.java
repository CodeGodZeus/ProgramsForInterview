/* 

Objec­tive:  Given an array of integer write an algorithm to find the majority element in it (if exist).

Majority Element: If an element appears more than n/2 times in array where n is the size of the array.

Example:

int [] arrA = {1,3,5,5,5,5,4,1,5};
Output: Element appearing more than n/2 times: 5

int []arrA = {1,2,3,4};
Output: No element appearing more than n/2 time
Earlier we have seen Majority Element solutions using hash map and sorting. In this article we will see O(n) solution with constant extra space.

Approach: Boyer–Moore majority vote algorithm

In its simplest form, the algorithm finds a majority element, if there is one: that is, an element that occurs repeatedly for more than half of the elements of the input. However, if there is no majority, the algorithm will not detect that fact, and will still output one of the elements. A version of the algorithm that makes a second pass through the data can be used to verify that the element found in the first pass really is a majority. Source – wiki

As per above algorithm we can divide out implementation into two parts

First iteration – Find the element which could be a majority element.
Second iteration – check the element(found in first iteration) count is greater than n/2
First iteration – Find the element which could be a majority element

Say Array has 10 elements and say element x appears 6 times. Rest of the elements count = 4. If we start cancel out each occurrence of x with rest of the elements, still at the end we will have some count of x remaining. In our example (6-4 =2, x count )
Iterate through array and maintain the count of majority_element.(starts with first element in the array.)
If next element is same then increment the count
If next element is not same then decrement the count.
If count becomes zero then majority_element = current element, count =1.
After the first iteration majority_element will be the candidate which might have the count > n/2.
Second iteration – check the element (found in first iteration) count is greater than n/2

Iterate through array and get the count of element found in first step. If count is >n/2 then print it.
If count is less than n/2 then ignore it, array does not have majority element.
Time Complexity: O(n), Space Complexity: O(1)
*/


 PROGRAM:----------------
 public class Boyer_Moore {
    public static void find(int [] arrA) {
        int size = arrA.length;
        if(size==0)
            return;

        int majorityElement = arrA[0];
        int count = 1;
        for (int i = 1; i <size ; i++) {
            if(majorityElement==arrA[i]){
                count++;
            }else if(count==0){
                majorityElement = arrA[i];
                count = 1;
            }else {
                count --;
            }
        }
        //check if majorityElement is appearing more than n/2 times
        count = 0;
        for (int i = 0; i < size ; i++) {
            if(arrA[i]==majorityElement){
                count++;
            }
        }
        if (count>size/2)
            System.out.println("(Boyer_Moore)Element appearing more than n/2 times: " + majorityElement);
        else
            System.out.println("No element appearing more than n/2 times");
    }

    public static void main(String[] args) {
        int [] arrA = {1,3,5,5,5,5,4,1,5};
        find(arrA);
    }
}
