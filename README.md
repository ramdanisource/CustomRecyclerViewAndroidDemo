# Custom RecyclerView Android Demo

Simple Custom RecyclerView in Android with Model <code>Bookmark</code> and Adapter <code>BookmarkAdapter</code>

## Config

with divider, use class <code>DividerItemDecoration</code>

implementation

```java

LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

//set Devider
DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rvBookmark.getContext(), linearLayoutManager.getOrientation());

//set layout
rvBookmark.setLayoutManager(linearLayoutManager);

//devider
rvBookmark.addItemDecoration(dividerItemDecoration);

```
use tools attributes in xml RecyclerView for see custom list item from another xml.

example

``` xml

<android.support.v7.widget.RecyclerView
        android:id="@+id/rv_list_bookmark"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        tools:listitem="@layout/custom_list_bookmark">
</android.support.v7.widget.RecyclerView>

```


## Reference

- https://guides.codepath.com/android/using-the-recyclerview
- https://developer.android.com/reference/android/support/v7/widget/DividerItemDecoration.html
- https://developer.android.com/studio/write/tool-attributes.html
