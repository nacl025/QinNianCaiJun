package com.edmund.qingniancaijun.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.edmund.qingniancaijun.Adapter.CategoryAdapter;
import com.edmund.qingniancaijun.Adapter.MenuAdapter;
import com.edmund.qingniancaijun.Model.CategoryItem;
import com.edmund.qingniancaijun.Model.MenuItem;
import com.edmund.qingniancaijun.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edmund on 2015/12/31.
 */
public class MenuFragment extends Fragment {

    private View rootView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.order_layout,
                container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final CategoryAdapter<CategoryItem> categoryAdapter = new CategoryAdapter<CategoryItem>(getActivity(), R.layout.category_item,
                getCategoryData());
        final ListView categoryListview = (ListView)rootView.findViewById(R.id.category_listView);
        categoryListview.setAdapter(categoryAdapter);

        final MenuAdapter<MenuItem> menuAdapter = new MenuAdapter<MenuItem>(getActivity(), -1,
                getMenuData());
        final ListView menuListview = (ListView)rootView.findViewById(R.id.menu_listView);
        menuListview.setAdapter(menuAdapter);

        categoryListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //TODO ==============优化==============
                ListView menuListview = (ListView) rootView.findViewById(R.id.menu_listView);
                int menuitemposition = 0;
                List<MenuItem> list = menuAdapter.getmDataSources();
                for (int i = 0; i < list.size(); i++) {
                    CategoryItem cItem = categoryAdapter.getItem(position);
                    if (list.get(i).getmCategoryID().equals(cItem.getID())) {
                        menuitemposition = i;
                        break;
                    }
                }
                menuListview.setSelection(menuitemposition);
                //TODO ===============================

              /*  categoryAdapter.setSelectedIndex(position);
                categoryAdapter.notifyDataSetChanged();
*/
            }
        });


        menuListview.setOnScrollListener(new AbsListView.OnScrollListener(){
            //TODO =====优化===========
            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                MenuItem item = menuAdapter.getmDataSources().get(firstVisibleItem);
                int itemposition = 0;
                List<CategoryItem> list = categoryAdapter.getmDataSources();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getID().equals(item.getmCategoryID())) {
                        itemposition = i;
                        break;
                    }
                }
                categoryAdapter.setSelectedIndex(itemposition);
                categoryAdapter.notifyDataSetChanged();
            }

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }
            //TODO=======================
        });
    }

    private List<CategoryItem> getCategoryData(){
        String[] categoryNameArray = getResources().getStringArray(R.array.category_name);
        String[] cateotryIDArray = getResources().getStringArray(R.array.category_id);

        List<CategoryItem> list = new ArrayList<CategoryItem>();
        for (int i = 0; i < categoryNameArray.length; i++) {
            CategoryItem item = new CategoryItem(cateotryIDArray[i], categoryNameArray[i]);
            list.add(item);
        }

        return list;
    }

    private List<MenuItem> getMenuData(){
        List<MenuItem> list = new ArrayList<MenuItem>();

        MenuItem item1 = new MenuItem("新人专区","1001");
        MenuItem menuItem0 = new MenuItem("0", "尖椒肉丝", 1, 14, true, false, "http://....", "1001");
        MenuItem menuItem1 = new MenuItem("1", "宫保鸡丁", 1, 14, true, false, "http://....", "1001");
        MenuItem menuItem2 = new MenuItem("2", "鱼香肉丝", 1, 14, true, false, "http://....", "1001");
        MenuItem menuItem3 = new MenuItem("3", "回锅肉", 1, 14, true, false, "http://....", "1001");
        list.add(item1);
        list.add(menuItem0);
        list.add(menuItem1);
        list.add(menuItem2);
        list.add(menuItem3);

        MenuItem item2 = new MenuItem("冬季温补","1002");
        MenuItem menuItem4 = new MenuItem("4", "菜君黄焖鸡", 18.00, 0, false, false, "http://....", "1002");
        MenuItem menuItem5 = new MenuItem("5", "高汤小米炖刺参", 36.00, 0, false, false, "http://....", "1002");
        MenuItem menuItem6 = new MenuItem("6", "孜然羊肉", 26.00, 0, false, false, "http://....", "1002");
        MenuItem menuItem7 = new MenuItem("7", "私房板栗三杯鸡", 18.00, 0, false, false, "http://....", "1002");
        list.add(item2);
        list.add(menuItem4);
        list.add(menuItem5);
        list.add(menuItem6);
        list.add(menuItem7);

        MenuItem item3 = new MenuItem("新品推荐","1003");
        MenuItem menuItem8 = new MenuItem("8", "七味蔬彩", 38.80, 0, false, false, "http://....", "1003");
        MenuItem menuItem9 = new MenuItem("9", "天府牛扒", 16, 0, false, false, "http://....", "1003");
        MenuItem menuItem10 = new MenuItem("10", "茶树菇炒牛柳", 28.00, 0, false, false, "http://....", "1003");
        MenuItem menuItem11 = new MenuItem("11", "西兰花炒双菇", 12.00, 0, false, false, "http://....", "1003");
        MenuItem menuItem12 = new MenuItem("12", "香脆小辣椒", 6.00, 0, false, false, "http://....", "1003");
        MenuItem menuItem13 = new MenuItem("13", "花生红椒小小酥", 6.00, 0, false, false, "http://....", "1003");
        MenuItem menuItem14 = new MenuItem("14", "栗子红烧肉", 30.00, 0, false, false, "http://....", "1003");
        MenuItem menuItem15 = new MenuItem("15", "草菇滑鸡片", 18.00, 0, false, false, "http://....", "1003");
        MenuItem menuItem16 = new MenuItem("16", "党参滋补乌鸡汤", 28.00, 0, false, false, "http://....", "1003");
        MenuItem menuItem17 = new MenuItem("17", "玉米笋炒西兰花", 13.00, 0, false, false, "http://....", "1003");
        MenuItem menuItem18 = new MenuItem("18", "山楂炖牛腩", 28.00, 0, false, false, "http://....", "1003");
        MenuItem menuItem19 = new MenuItem("19", "话梅小排", 24.00, 0, false, false, "http://....", "1003");
        MenuItem menuItem20 = new MenuItem("20", "杭州片儿川", 12.00, 0, false, false, "http://....", "1003");
        MenuItem menuItem21 = new MenuItem("21", "北京炸酱面", 18.00, 0, false, false, "http://....", "1003");
        MenuItem menuItem22 = new MenuItem("22", "厦门沙茶面", 18.00, 0, false, false, "http://....", "1003");
        MenuItem menuItem23 = new MenuItem("23", "太原刀削面", 12.00, 0, false, false, "http://....", "1003");
        MenuItem menuItem24 = new MenuItem("24", "武汉热干面", 8.00, 0, false, false, "http://....", "1003");
        MenuItem menuItem25 = new MenuItem("25", "重庆豌杂面", 12.00, 0, false, false, "http://....", "1003");
        list.add(item3);
        list.add(menuItem8);
        list.add(menuItem9);
        list.add(menuItem10);
        list.add(menuItem11);
        list.add(menuItem12);
        list.add(menuItem13);
        list.add(menuItem14);
        list.add(menuItem15);
        list.add(menuItem16);
        list.add(menuItem17);
        list.add(menuItem18);
        list.add(menuItem19);
        list.add(menuItem20);
        list.add(menuItem21);
        list.add(menuItem22);
        list.add(menuItem23);
        list.add(menuItem24);
        list.add(menuItem25);

        MenuItem item4 = new MenuItem("福利专享","1004");
        MenuItem menuItem26 = new MenuItem("26", "鱼香肉丝+西芹番茄炒菜花", 23.00, 0, false, false, "http://....", "1004");
        MenuItem menuItem27 = new MenuItem("27", "私房板栗三杯鸡+尖椒土豆丝", 25.50, 0, false, false, "http://....", "1004");
        MenuItem menuItem28 = new MenuItem("28", "宫保鸡丁+手撕包菜炒五花肉", 23.00, 0, false, false, "http://....", "1004");
        MenuItem menuItem29 = new MenuItem("29", "耗油冬笋鸡片+玉米笋炒西兰花", 27.00, 0, false, false, "http://....", "1004");
        list.add(item4);
        list.add(menuItem26);
        list.add(menuItem27);
        list.add(menuItem28);
        list.add(menuItem29);

        MenuItem item5 = new MenuItem("素菜","1005");
        MenuItem menuItem30 = new MenuItem("30", "尖椒土豆丝", 7.50, 0, false, false, "http://....", "1005");
        MenuItem menuItem31 = new MenuItem("31", "西芹番茄炒菜花", 9.00, 0, false, false, "http://....", "1005");
        MenuItem menuItem32 = new MenuItem("32", "松仁玉米", 11.00, 0, false, false, "http://....", "1005");
        MenuItem menuItem33 = new MenuItem("33", "玉米笋炒西兰花", 13.00, 0, false, false, "http://....", "1005");
        MenuItem menuItem34 = new MenuItem("34", "木耳鸡蛋炒莴笋", 9.00, 0, false, false, "http://....", "1005");
        MenuItem menuItem35 = new MenuItem("35", "尖椒鸡蛋", 7.50, 0, false, false, "http://....", "1005");
        MenuItem menuItem36 = new MenuItem("36", "西葫芦炒木耳", 8.00, 0, false, false, "http://....", "1005");
        list.add(item5);
        list.add(menuItem30);
        list.add(menuItem31);
        list.add(menuItem32);
        list.add(menuItem33);
        list.add(menuItem34);
        list.add(menuItem35);
        list.add(menuItem36);

        MenuItem item6 = new MenuItem("荤菜","1006");
        MenuItem menuItem37 = new MenuItem("37", "麻辣香锅", 28.00, 0, false, false, "http://....", "1006");
        MenuItem menuItem38 = new MenuItem("38", "木须肉", 11.00, 0, false, false, "http://....", "1006");
        MenuItem menuItem39 = new MenuItem("39", "香葱培根花椰菜", 16.50, 0, false, false, "http://....", "1006");
        MenuItem menuItem40 = new MenuItem("40", "香辣土豆片炒五花肉", 14.00, 0, false, false, "http://....", "1006");
        MenuItem menuItem41 = new MenuItem("41", "豆豉鲮鱼油麦菜", 9.00, 0, false, false, "http://....", "1006");
        MenuItem menuItem42 = new MenuItem("42", "榄菜肉末四季豆", 11.00, 0, false, false, "http://....", "1006");
        MenuItem menuItem43 = new MenuItem("43", "蘑菇炒肉片", 15.00, 0, false, false, "http://....", "1006");
        MenuItem menuItem44 = new MenuItem("44", "手撕包菜炒五花肉", 9.00, 0, false, false, "http://....", "1006");
        MenuItem menuItem45 = new MenuItem("45", "蒜薹炒肉", 14.00, 0, false, false, "http://....", "1006");
        MenuItem menuItem46 = new MenuItem("46", "黑椒牛肉粒", 24.00, 0, false, false, "http://....", "1006");
        MenuItem menuItem47 = new MenuItem("47", "黑三剁", 13.00, 0, false, true, "http://....", "1006");
        list.add(item6);
        list.add(menuItem37);
        list.add(menuItem38);
        list.add(menuItem39);
        list.add(menuItem40);
        list.add(menuItem41);
        list.add(menuItem42);
        list.add(menuItem43);
        list.add(menuItem44);
        list.add(menuItem45);
        list.add(menuItem46);
        list.add(menuItem47);

        MenuItem item7 = new MenuItem("肉菜","1007");
        MenuItem menuItem48 = new MenuItem("48", "蜜汁烧鸡翅", 24.00, 0, false, false, "http://....", "1007");
        MenuItem menuItem49 = new MenuItem("49", "京酱肉丝", 15.00, 0, false, false, "http://....", "1007");
        MenuItem menuItem50 = new MenuItem("50", "黑椒汁澳洲草饲牛排", 23.99, 0, false, false, "http://....", "1007");
        MenuItem menuItem51 = new MenuItem("51", "豉汁蒸排骨", 24.00, 0, false, false, "http://....", "1007");
        list.add(item7);
        list.add(menuItem48);
        list.add(menuItem49);
        list.add(menuItem50);
        list.add(menuItem51);

        MenuItem item8 = new MenuItem("汤羹","1008");
        MenuItem menuItem52 = new MenuItem("52", "辣白菜五花肉豆腐汤", 14.00, 0, false, false, "http://....", "1008");
        list.add(item8);
        list.add(menuItem52);

        MenuItem item9 = new MenuItem("一城一面","1009");
        MenuItem menuItem53 = new MenuItem("53", "小面", 15.00, 0, false, false, "http://....", "1009");
        list.add(item9);
        list.add(menuItem53);

        MenuItem item10 = new MenuItem("酱心小菜","1010");
        MenuItem menuItem54 = new MenuItem("54", "辣白菜和欧巴的秘密", 1.00, 5.00, true, false, "http://....", "1010");
        MenuItem menuItem55 = new MenuItem("55", "这酸爽的开胃小黄瓜", 1.00, 5.00, true, false, "http://....", "1010");
        MenuItem menuItem56 = new MenuItem("56", "肉酱蘑菇丁的香辣暴脾气", 1.00, 5.00, true, false, "http://....", "1010");
        list.add(item10);
        list.add(menuItem54);
        list.add(menuItem55);
        list.add(menuItem56);

        MenuItem item11 = new MenuItem("火锅系列","1011");
        MenuItem menuItem57 = new MenuItem("57", "双人肥牛火锅套餐", 56.00, 64.30, true, false, "http://....", "1011");
        MenuItem menuItem58 = new MenuItem("58", "双人羊肉火锅套餐", 58.00, 67.50, true, false, "http://....", "1011");
        MenuItem menuItem59 = new MenuItem("59", "海底捞底料(鲜香味)",9.50, 0, false, false, "http://....", "1011");
        MenuItem menuItem60 = new MenuItem("60", "海底捞底料(麻辣味)",9.50, 0, false, false, "http://....", "1011");
        list.add(item11);
        list.add(menuItem57);
        list.add(menuItem58);
        list.add(menuItem59);
        list.add(menuItem60);

        return list;
    }
}
