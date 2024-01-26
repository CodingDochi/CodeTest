
# What is a Heap?

힙은 각 노드가 그것의 자식보다 크거나 같고(최대 힙), 또는 작거나 같은(최소 힙) 이진트리입니다. 

아래 그림은 최대힙의 예시입니다.
![](https://www.happycoders.eu/wp-content/uploads/2020/08/heapsort_max_heap_example-v2-336x235.png)

9는 8과 5보다 크며, 8은 7과 2보다 큽니다.

힙은 해당 요소를 왼쪽 상단에서 오른쪽 하단으로 한 줄씩 배열로 전송(transfer)하여 배열에 투영(projected to)됩니다.
![](https://www.happycoders.eu/wp-content/uploads/2020/08/heapsort_max_heap_to_array-v2-400x267.png)
위에 표시된 힙은 아래 배열과 같습니다. 

![](https://www.happycoders.eu/wp-content/uploads/2020/08/heapsort_max_heap_as_array-v2-504x48.png)
최대 힙에서 가장 큰 요소가 최상위에 있고, 배열 형식에서는 가장 왼쪽에 있습니다. 

# Heap Sort Algorithm
힙 정렬 알고리즘은 두 단계로 구성됩니다. 첫 번째 단계에서는 정렬할 배열이 최대 힙으로 변환됩니다.
두 번째 단계에서는 가장 큰 요소(즉, 트리 루트에 있는 요소)가 제거되고 나머지 요소에서 새로운 최대 힙이 생성됩니다.

## Phase 1 : Creating the Heap
정렬할 배열은 먼저 반드시 힙으로 변환해야 합니다. 이를 위해 새로운 데이터 구조가 생성되지 않고 배열 내에서 숫자가 재배열되어 위에서 설명한 힙 구조가 생성됩니다.

아래 숫자 배열 [3, 7, 1, 8, 2, 5, 9, 4, 6] 을 가지고 설명하겠습니다. 위에서 설명한 대로 이 숫자를 이진 트리에 "투영(Project)"합니다. 이진 트리는 별도의 데이터 구조가 아니라 사고 구조(thought construct)일 뿐입니다. 컴퓨터 메모리에서 요소는 배열에만 위치합니다. 

![](https://www.happycoders.eu/wp-content/uploads/2020/08/heapsort_buildheap_algorithm_step01-336x261.png)

이 트리는 아직 최대 힙을 나타내지 않습니다. 최대 힙의 정의는 부모가 항상 자식보다 크거나 같다는 것입니다.

최대 힙을 생성하기 위해 이제 마지막 노드부터 첫 번째 노드까지 모든 상위 노드를 방문하고 해당 노드와 아래 노드에 대한 힙 조건이 충족되는지 확인합니다. 우리는 소위 heapify() 메소드를 사용하여 이를 수행합니다.

### invocation no.1 of the Heapify Method

heapify() 메서드는 마지막 부모 노드에 대해 먼저 호출됩니다. 부모 노드는 3, 7, 1, 8입니다. 마지막 부모 노드는 8입니다. heapify() 함수는 자식 노드가 부모 노드보다 작은지 확인합니다. 4와 6은 8보다 작으므로 이 상위 노드에서 힙 조건이 충족되고 heapify() 함수가 종료됩니다.


![](https://www.happycoders.eu/wp-content/uploads/2020/08/heapsort_buildheap_algorithm_step02-336x261.png)

### invocation no.2 of the Heapify Method

둘째, 끝에서 두 번째(penultimate) 노드인 1에 대해 heapify()가 호출됩니다. 해당 하위 노드 5와 9가 모두 1보다 크므로 힙 조건이 위반(violated)됩니다. 힙 조건을 복원하기 위해 이제 더 큰 하위 노드를 상위 노드로 바꿉니다. 즉, 9를 1로 바꿉니다. 이제 heapify() 메서드가 다시 완료됩니다.

![](https://www.happycoders.eu/wp-content/uploads/2020/08/heapsort_buildheap_algorithm_step03-800x294.png)

### invocation no.3 of the Heapify Method

이제 heapify()가 7에서 호출됩니다. 하위 노드는 8과 2입니다. 8만이 상위 노드보다 큽니다. 그래서 우리는 7을 8로 교환합니다:

![](https://www.happycoders.eu/wp-content/uploads/2020/08/heapsort_buildheap_algorithm_step04-800x295.png)

방금 교체한 하위 노드에는 두 개의 하위 노드가 있으므로 이제 heapify() 메서드는 이 하위 노드에 대한 힙 조건이 여전히 유효한지 확인해야 합니다. 이 경우 7은 4와 6보다 큽니다. 힙 조건이 충족되고 heapify() 함수가 완료됩니다.

![](https://www.happycoders.eu/wp-content/uploads/2020/08/heapsort_buildheap_algorithm_step05-336x261.png)

### invocation no.4 of the Heapify Method

이제 우리는 요소 3이 있는 루트 노드에 도착했습니다. 두 하위 노드인 8과 9는 모두 더 크고 9는 가장 큰 하위 노드이므로 상위 노드와 교체됩니다.

![](https://www.happycoders.eu/wp-content/uploads/2020/08/heapsort_buildheap_algorithm_step06-800x295.png)

이번에도 교체된 하위 노드에는 하위 노드가 있으므로 이 하위 노드의 힙 상태를 확인해야 합니다. 5가 3보다 큽니다. 즉, 힙 조건이 충족되지 않습니다. 5와 3을 바꿔서 복원해야 합니다.

![](https://www.happycoders.eu/wp-content/uploads/2020/08/heapsort_buildheap_algorithm_step07-800x295.png)

heapify() 함수의 네 번째이자 마지막 호출이 완료되었습니다. 최대 힙이 생성되었습니다.

![](https://www.happycoders.eu/wp-content/uploads/2020/08/heapsort_buildheap_algorithm_step08-336x260.png)

## Phase 2 : Sorting the Array

2단계에서는 최대 힙의 가장 큰 요소가 항상 루트(배열에서 가장 왼쪽)에 있다는 사실을 활용합니다.

### Step 1 : Swapping the Root and Last Elements

이제 루트 요소(9)가 마지막 요소(6)로 교체되어 9가 배열 끝의 최종 위치(배열에서 파란색으로 표시됨)에 있게 됩니다. 또한 트리에서 이 요소를 제거합니다(회색으로 표시됨).

![](https://www.happycoders.eu/wp-content/uploads/2020/08/heapsort_algorithm_phase2_step01-800x296.png)

6을 트리의 루트에 배치한 후에는 더 이상 최대 힙이 아닙니다. 따라서 다음 단계에서는 힙을 "복구"합니다.

### Step 2 : Restoring the Heap Condition

힙 조건을 복원하기 위해 루트 노드에서 1단계에서 알려진 heapify() 메서드를 호출합니다. 이는 6을 그 자식인 8과 5와 비교한다는 의미입니다. 8이 더 크므로 6과 바꿉니다.

![](https://www.happycoders.eu/wp-content/uploads/2020/08/heapsort_algorithm_phase2_step02-800x295.png)

교체된 하위 노드에는 7과 2라는 두 개의 하위 노드가 있습니다. 7은 6보다 크므로 이 두 요소도 교체합니다.

![](https://www.happycoders.eu/wp-content/uploads/2020/08/heapsort_algorithm_phase2_step03-800x295.png)

교환된 하위 노드에는 하위 노드 4도 있습니다. 6은 4보다 크므로 이 노드에서 힙 조건이 충족됩니다. heapify() 함수가 완료되고 다시 최대 힙이 생성됩니다.

![](https://www.happycoders.eu/wp-content/uploads/2020/08/heapsort_algorithm_phase2_step04-336x260.png)

## Repeating the Steps

나머지 배열의 가장 큰 숫자인 8이 이제 첫 번째 위치에 있습니다. 이를 트리의 마지막 요소와 교환합니다. 트리를 한 요소만큼 줄였으므로 트리의 마지막 요소는 배열의 마지막 두 번째 필드에 있습니다.

![](https://www.happycoders.eu/wp-content/uploads/2020/08/heapsort_algorithm_phase2_step05-800x286.png)

이제 배열의 마지막 두 필드가 정렬되었습니다. 루트에서는 힙 조건이 다시 위반됩니다. 루트 요소에서 heapify()를 호출하여 트리를 복구합니다(다음 그림은 모든 heapify 단계를 한 번에 보여줍니다).

![](https://www.happycoders.eu/wp-content/uploads/2020/08/heapsort_algorithm_phase2_step06-800x240.png)

트리에 요소가 하나만 남을 때까지 프로세스를 반복합니다.

![](https://www.happycoders.eu/wp-content/uploads/2020/08/heapsort_algorithm_phase2_step07-800x213.png)

이 요소는 가장 작으며 배열의 시작 부분에 남아 있습니다. 알고리즘이 완료되고 배열이 정렬됩니다.

![](https://www.happycoders.eu/wp-content/uploads/2020/08/heapsort_algorithm_phase2_step08-336x32.png)