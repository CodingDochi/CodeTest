![](https://miro.medium.com/v2/resize:fit:640/format:webp/1*DtH6fEdBhoUGnjBWudJ8pA.png)

![](https://algs4.cs.princeton.edu/23quicksort/images/quicksort-overview.png)

![](https://algs4.cs.princeton.edu/23quicksort/images/partitioning-overview.png)

![](https://algs4.cs.princeton.edu/23quicksort/images/partitioning.png)

![](https://algs4.cs.princeton.edu/23quicksort/images/quicksort.png)

![](https://miro.medium.com/v2/resize:fit:720/format:webp/1*9Ydg_JYZ7m50kQW8nBH9Yg.png)

<table class="alt">
<tbody><tr>
<th>S.N.</th>
<th>Parameter</th>
<th>퀵 정렬</th>
<th>병합 정렬</th>
</tr>
<tr>
<td><strong>1.</strong></td>
<td><strong>정의</strong></td>
<td>주어진 요소를 비교하고 위치를 바꿔서 오름차순으로 정렬하는 퀵 정렬 알고리즘입니다.</td>
<td>분할 정복 기법을 사용하여 주어진 요소 집합을 오름차순으로 정렬하는 병합 정렬 알고리즘입니다.</td>
</tr>
<tr>
<td><strong>2.</strong></td>
<td><strong>원리</strong></td>
<td>분할 정복 기법을 기반으로 합니다.</td>
<td>분할 정복 기법을 기반으로 합니다.</td>
</tr>
<tr>
<td><strong>3.</strong></td>
<td><strong>요소의 분할</strong></td>
<td>퀵 정렬에서는 배열을 어떤 비율로든 나눌 수 있습니다.</td>
<td>병합 정렬에서는 배열을 두 하위 배열(N/2)로 나눕니다.</td>
</tr>
<tr>
<td><strong>4.</strong></td>
<td><strong>효율성</strong></td>
<td>더 작은 크기의 배열에서는 더 효율적이며 더 빠르게 작동합니다.</td>
<td>더 큰 데이터 세트 또는 배열에서는 더 효율적이며 더 빠르게 작동합니다.</td>
</tr>
<tr>
<td><strong>5.</strong></td>
<td><strong>정렬 방법</strong></td>
<td>내부 정렬 방법으로 주어진 배열 또는 데이터를 정렬합니다.</td>
<td>외부 정렬 방법으로 주어진 배열 또는 데이터 세트를 정렬합니다.</td>
</tr>
<tr>
<td><strong>6</strong></td>
<td><strong>시간 복잡도</strong></td>
<td>퀵 정렬의 최악의 시간 복잡도는 O(n^2)입니다.</td>
<td>반면에 병합 정렬의 최악의 시간 복잡도는 O(n log n)입니다.</td>
</tr>
<tr>
<td><strong>7</strong></td>
<td><strong>선호도</strong></td>
<td>큰 정렬되지 않은 배열에 적합한 정렬 알고리즘입니다.</td>
<td>병합 정렬 알고리즘은 연결된 목록을 정렬하는 데 적합합니다.</td>
</tr>
<tr>
<td><strong>8</strong></td>
<td><strong>안정성</strong></td>
<td>퀵 정렬은 불안정한 정렬 알고리즘입니다. 그러나 프로그래밍 코드를 수정하여 안정성을 확보할 수 있습니다.</td>
<td>병합 정렬은 안정적인 정렬 알고리즘으로 동일한 값을 가진 두 요소가 정렬된 출력에서 동일한 순서로 유지됩니다.</td>
</tr>
<tr>
<td><strong>9</strong></td>
<td><strong>공간 필요성</strong></td>
<td>퀵 정렬은 퀵 정렬을 수행하는 데 추가 공간이 필요하지 않습니다.</td>
<td>병합 정렬은 두 하위 배열을 병합하기 위해 임시 배열로 추가 공간이 필요합니다.</td>
</tr>
<tr>
<td><strong>10.</strong></td>
<td><strong>기능</strong></td>
<td>각 요소를 피벗과 비교하여 모든 요소를 오름차순으로 정렬합니다.</td>
<td>병합 정렬은 배열을 두 부분(N/2)으로 나누고 요소가 남지 않을 때까지 배열을 계속해서 나눕니다.</td>
</tr>
</tbody></table>
```