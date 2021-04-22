//package com.example.appvideo;
//
//import android.content.Context;
//import android.util.Log;
//import android.widget.Toast;
//
//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.StringRequest;
//import com.android.volley.toolbox.Volley;
//import com.example.appvideo.Json.Json;
//import com.example.appvideo.model.AllCategory;
//import com.example.appvideo.model.CategoryItem;
//
//import org.json.JSONException;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ggggg {
//    private Json json;
//    private Context context;
//    private List<CategoryItem> allCategoryList;
//
//    private void testhhh( ) {
//
//        RequestQueue requestQueue = Volley.newRequestQueue(context);
//
//        allCategoryList = new ArrayList<>();
//
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, "https://api.themoviedb.org/3/movie/now_playing?api_key=9ed4a1f097a3e78ed51133843d2156ea&language=vi-VN&page=1",
//                new Response.Listener<String>() {
//
//                    @Override
//                    public void onResponse(String response) {
//                        try {
//                            List<CategoryItem> movieDetailList = new ArrayList<>();
//                            movieDetailList = json.JSONmovielist(response);
//
//                            allCategoryList.add(new AllCategory("Đang chiếu rạp", 1, movieDetailList));
//
//
//                            setMainRecyclerview(allCategoryList);
//
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(context, "Lỗi", Toast.LENGTH_SHORT).show();
//                Log.d("AAA", "Lỗi\n" + error.toString());
//            }
//        });
//        requestQueue.add(stringRequest);
//
//
//    }
//}
