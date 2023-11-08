import random
import time

# Deterministic Quick Sort
def deterministic_quick_sort(arr):
    if len(arr) <= 1:
        return arr

    pivot = arr[len(arr) // 2]
    left = [x for x in arr if x < pivot]
    middle = [x for x in arr if x == pivot]
    right = [x for x in arr if x > pivot]

    return deterministic_quick_sort(left) + middle + deterministic_quick_sort(right)

# Randomized Quick Sort
def randomized_quick_sort(arr):
    if len(arr) <= 1:
        return arr

    pivot = random.choice(arr)
    left = [x for x in arr if x < pivot]
    middle = [x for x in arr if x == pivot]
    right = [x for x in arr if x > pivot]

    return randomized_quick_sort(left) + middle + randomized_quick_sort(right)

# Measure execution time for each variant
def measure_time(func, arr):
    start_time = time.time()
    sorted_arr = func(arr)
    end_time = time.time()
    return arr, sorted_arr, end_time - start_time

# Main analysis function
def analyze_quick_sort():
    input_size = [5, 6]
    
    for size in input_size:
        arr = [random.randint(1, size) for _ in range(size)]
        
        print(f"Input size: {size}")
        
        # Analyze deterministic Quick Sort
        original_arr, sorted_arr, time_taken = measure_time(deterministic_quick_sort, arr.copy())
        print(f"Deterministic Quick Sort - Time taken: {time_taken:.6f} seconds")
        print("Original Array:", original_arr)
        print("Sorted Array:", sorted_arr)
        
        # Analyze randomized Quick Sort
        original_arr, sorted_arr, time_taken = measure_time(randomized_quick_sort, arr.copy())
        print(f"Randomized Quick Sort - Time taken: {time_taken:.6f} seconds")
        print("Original Array:", original_arr)
        print("Sorted Array:", sorted_arr)
        print()

if __name__ == "__main__":
    analyze_quick_sort()
