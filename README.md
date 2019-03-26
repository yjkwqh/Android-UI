# Android-UI
android UI组件
@[TOC](Third Test)

# 第三个实验
## Android  UI 组件
运行主界面：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190326134900859.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3ZhZ2Fib25kXw==,size_16,color_FFFFFF,t_70)

1.Android ListView的用法：![在这里插入图片描述](https://img-blog.csdnimg.cn/20190326135551455.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3ZhZ2Fib25kXw==,size_16,color_FFFFFF,t_70)

核心代码：
```java
public class AnimalsActivity extends AppCompatActivity {
//    private List<Animals> animalsList = new ArrayList<>();
    private   List<Map<String, Object>> listItems;
    private String[] names = new String[]
        { "Lion", "Tiger", "Monkey", "Dog","Cat","Elephant"};
    private int[] imageIds = new int[]
            { R.drawable.lion,R.drawable.tiger , R.drawable.monkey,
                    R.drawable.dog , R.drawable.cat,R.drawable.elephant};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        this.setTitle("Android ListView");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; i++)
        {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("animalName", names[i]);
            listItem.put("image", imageIds[i]);
            listItems.add(listItem);
        }
        // 创建一个SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems,
                R.layout.animals_layout,
                new String[] {  "animalName", "image"},
                new int[] { R.id.animals_name, R.id.animals_image });
//        initAnimals();
//        AnimalsAdapter adapter = new AnimalsAdapter(AnimalsActivity.this,R.layout.animals_layout,animalsList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(AnimalsActivity.this,names[position],Toast.LENGTH_SHORT).show();
//                Animals animals = (Animals) listItems.get(position);
//                Toast.makeText(AnimalsActivity.this,animals.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

```
运行截图：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190326135644478.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3ZhZ2Fib25kXw==,size_16,color_FFFFFF,t_70)


2.创建自定义布局的AlertDial：
![在这里插入图片描述](https://img-blog.csdnimg.cn/2019032613573366.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3ZhZ2Fib25kXw==,size_16,color_FFFFFF,t_70)
核心代码：
```java
public class AlterDialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setTitle("AlterDialog");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog builder = new AlertDialog.Builder(AlterDialog.this)
                        .setView(R.layout.dialog_layout)
                        .setNegativeButton("Cancel",null)
                        .setPositiveButton("Sign in",null)
                        .create();
                builder.show();
            }
        });
    }
}
```
dialog_layout.xml
```java
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_gravity="center">
    <ImageView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:scaleType="centerCrop"
        android:src="@drawable/header_logo"/>
    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Username"/>
    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="textPassword"
        android:hint="Password"
        />

</LinearLayout>

```
运行截图：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190326135934286.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3ZhZ2Fib25kXw==,size_16,color_FFFFFF,t_70)
3.使用XML定义菜单 ：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190326140023847.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3ZhZ2Fib25kXw==,size_16,color_FFFFFF,t_70)
核心代码：
```java
public class MenuActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setTitle("XML定义菜单");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        TextView textView =(TextView) findViewById(R.id.text);
        switch (item.getItemId()){
            case R.id.z1:
                textView.setTextSize(10);break;
            case R.id.z2:
                textView.setTextSize(16);break;
            case R.id.z3:
                textView.setTextSize(20);break;
            case R.id.y1:
                textView.setTextColor(Color.RED);break;
            case R.id.y2:
                textView.setTextColor(Color.BLACK);break;
            case R.id.p:
                Toast.makeText(this,"这是普通单击项",Toast.LENGTH_SHORT).show();
                break;
             default:
        }
        return true;
    }
}

```
menu_layout.xml
```java
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:id="@+id/z"
        android:title="字体大小"
        >
        <menu>
            <group>
                <item
                    android:id="@+id/z1"
                    android:title="10号字体"
                    />
                <item
                    android:id="@+id/z2"
                    android:title="16号字体"
                    />
                <item
                    android:id="@+id/z3"
                    android:title="20号字体"
                    />
            </group>
        </menu>
    </item>
    <item
        android:id="@+id/p"
        android:title="普通菜单项"
        >
    </item>
    <item
        android:id="@+id/y"
        android:title="字体颜色">
        <menu>
            <group>
                <item
                    android:id="@+id/y1"
                    android:title="红色"
                    />
                <item
                    android:id="@+id/y2"
                    android:title="黑色"
                    />
            </group>
        </menu>
    </item>

</menu>
```

运行截图：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190326140610119.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3ZhZ2Fib25kXw==,size_16,color_FFFFFF,t_70)
20号字体：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190326140312118.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3ZhZ2Fib25kXw==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190326140347681.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3ZhZ2Fib25kXw==,size_16,color_FFFFFF,t_70)
红色：
![在这里插入图片描述](https://img-blog.csdnimg.cn/2019032614062461.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3ZhZ2Fib25kXw==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190326140421609.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3ZhZ2Fib25kXw==,size_16,color_FFFFFF,t_70)
普通选项：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190326140442396.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3ZhZ2Fib25kXw==,size_16,color_FFFFFF,t_70)
4.创建上下文操作模式(ActionMode)的上下文菜单
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190326140721767.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3ZhZ2Fib25kXw==,size_16,color_FFFFFF,t_70)
核心代码：
```java
public class ActionMode extends AppCompatActivity {
    private ListView listView;
    private List<Number> numberList = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        this.setTitle("ActionMode");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actionmode_layout);
        initNumber();
        NumberAdapter adapter = new NumberAdapter(ActionMode.this,R.layout.number_layout,numberList);
        listView = (ListView) findViewById(R.id.list_view2);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public boolean onCreateActionMode(android.view.ActionMode mode, Menu menu) {
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.actionmode, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(android.view.ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(android.view.ActionMode mode, MenuItem item) {
                mode.finish();
                return false;
            }

            @Override
            public void onDestroyActionMode(android.view.ActionMode mode) {

            }

            @Override
            public void onItemCheckedStateChanged(android.view.ActionMode mode, int position, long id, boolean checked) {
                mode.setTitle(listView.getCheckedItemCount()+" selected");
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

            }
        });
    }

    private void initNumber(){
        for(int i=0;i<2;i++){
            Number one = new Number("One",R.mipmap.ic_launcher);
            numberList.add(one);
            Number two = new Number("Two",R.mipmap.ic_launcher);
            numberList.add(two);
            Number three = new Number("Three",R.mipmap.ic_launcher);
            numberList.add(three);
            Number four = new Number("four",R.mipmap.ic_launcher);
            numberList.add(four);
            Number five = new Number("five",R.mipmap.ic_launcher);
            numberList.add(five);
        }
    }
}
```
NumberAdapter
```java
public class NumberAdapter extends ArrayAdapter<Number> {
    private int resourceId;
    public NumberAdapter(@NonNull Context context, int resource, @NonNull List<Number> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Number number = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        ImageView numberImage=(ImageView)view.findViewById(R.id.num_image);
        TextView numberName=(TextView)view.findViewById(R.id.num_name);
        numberImage.setImageResource(number.getImageId());
        numberName.setText(number.getName());
        return view;
    }
}
```
运行截图：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190326140926372.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3ZhZ2Fib25kXw==,size_16,color_FFFFFF,t_70)
