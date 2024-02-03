package com.quickfix.displaytv.viewpagertransformation.Fragments;

import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.quickfix.displaytv.R;
import com.quickfix.displaytv.adapters.ProductsAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class TemplateOneFragment extends Fragment {

    private HashMap<String, HashMap<String, Object>> productMap;


    private TextView productOne;
    private TextView productTwo;
    private TextView productThree;
    private TextView productFour;
    private TextView productFive;
    private TextView productSix;
    private TextView productSeven;
    private TextView productEight;
    private TextView productNine;
    private TextView productTen;
    private TextView productEleven;
    private TextView productTwelve;

    private TextView desOne;
    private TextView desTwo;
    private TextView desThree;
    private TextView desFour;
    private TextView desFive;
    private TextView desSix;
    private TextView desSeven;
    private TextView desEight;
    private TextView desNine;
    private TextView desTen;
    private TextView desEleven;
    private TextView desTwelve;

    private TextView priceOne;
    private TextView priceTwo;
    private TextView priceThree;
    private TextView priceFour;
    private TextView priceFive;
    private TextView priceSix;
    private TextView priceSeven;
    private TextView priceEight;
    private TextView priceNine;
    private TextView priceTen;
    private TextView priceEleven;
    private TextView priceTwelve;


    private TextView priceDOne;
    private TextView priceDTwo;
    private TextView priceDThree;
    private TextView priceDFour;
    private TextView priceDFive;
    private TextView priceDSix;
    private TextView priceDSeven;
    private TextView priceDEight;
    private TextView priceDNine;
    private TextView priceDTen;
    private TextView priceDEleven;
    private TextView priceDTwelve;

    private TextView pageName;
    private ImageView imageStyleOne;
    private ImageView imageStyleTwo;
    private ImageView imageStyleThree;
    private ImageView imageOne;
    private ImageView imageTwo;
    private ImageView imageThree;
    private ImageView imageFour;
    private ImageView imageFive;
    private ImageView imageSix;
    private ImageView imageSeven;
    private ImageView imageEight;
    private ImageView imageNine;
    private ImageView imageTen;
    private ImageView imageEleven;
    private ImageView imageTwelve;

    private ArrayList<HashMap<String, Object>> pArrayList;
    private ArrayList<HashMap<String, String>> images;
    private String name;

    public TemplateOneFragment(HashMap<String, HashMap<String, Object>> productMap, ArrayList<HashMap<String, String>> images, String name) {
        // 350 * 350
        // 350 * 350
        // 700 * 350
        this.productMap = productMap;
        this.images = images;
        this.name = name;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_template_1, container, false);

        return v;


    }

    private void assignIds(View v) {
        pageName = v.findViewById(R.id.pageName);
        pageName.setText(name);
        imageStyleOne = v.findViewById(R.id.imageStyleOne);
        imageStyleTwo = v.findViewById(R.id.imageStyleTwo);
        imageStyleThree = v.findViewById(R.id.imageStyleThree);

        imageOne = v.findViewById(R.id.imageOne);
        imageTwo = v.findViewById(R.id.imageTwo);
        imageThree = v.findViewById(R.id.imageThree);
        imageFour = v.findViewById(R.id.imageFour);
        imageFive = v.findViewById(R.id.imageFive);
        imageSix = v.findViewById(R.id.imageSix);
        imageSeven = v.findViewById(R.id.imageSeven);
        imageEight = v.findViewById(R.id.imageEight);
        imageNine = v.findViewById(R.id.imageNine);
        imageTen = v.findViewById(R.id.imageTen);
        imageEleven = v.findViewById(R.id.imageEleven);
        imageTwelve = v.findViewById(R.id.imageTwelve);

        priceDOne = v.findViewById(R.id.priceDOne);
        priceDTwo = v.findViewById(R.id.priceDTwo);
        priceDThree = v.findViewById(R.id.priceDThree);
        priceDFour = v.findViewById(R.id.priceDFour);
        priceDFive = v.findViewById(R.id.priceDFive);
        priceDSix = v.findViewById(R.id.priceDSix);
        priceDSeven = v.findViewById(R.id.priceDSeven);
        priceDEight = v.findViewById(R.id.priceDEight);
        priceDNine = v.findViewById(R.id.priceDNine);
        priceDTen = v.findViewById(R.id.priceDTen);
        priceDEleven = v.findViewById(R.id.priceDEleven);
        priceDTwelve = v.findViewById(R.id.priceDTwelve);


        priceOne = v.findViewById(R.id.priceOne);
        priceTwo = v.findViewById(R.id.priceTwo);
        priceThree = v.findViewById(R.id.priceThree);
        priceFour = v.findViewById(R.id.priceFour);
        priceFive = v.findViewById(R.id.priceFive);
        priceSix = v.findViewById(R.id.priceSix);
        priceSeven = v.findViewById(R.id.priceSeven);
        priceEight = v.findViewById(R.id.priceEight);
        priceNine = v.findViewById(R.id.priceNine);
        priceTen = v.findViewById(R.id.priceTen);
        priceEleven = v.findViewById(R.id.priceEleven);
        priceTwelve = v.findViewById(R.id.priceTwelve);

        productOne = v.findViewById(R.id.productOne);
        productTwo = v.findViewById(R.id.productTwo);
        productThree = v.findViewById(R.id.productThree);
        productFour = v.findViewById(R.id.productFour);
        productFive = v.findViewById(R.id.productFive);
        productSix = v.findViewById(R.id.productSix);
        productSeven = v.findViewById(R.id.productSeven);
        productEight = v.findViewById(R.id.productEight);
        productNine = v.findViewById(R.id.productNine);
        productTen = v.findViewById(R.id.productTen);
        productEleven = v.findViewById(R.id.productEleven);
        productTwelve = v.findViewById(R.id.productTwelve);

        desOne = v.findViewById(R.id.descOne);
        desTwo = v.findViewById(R.id.descTwo);
        desThree = v.findViewById(R.id.descThree);
        desFour = v.findViewById(R.id.descFour);
        desFive = v.findViewById(R.id.descFive);
        desSix = v.findViewById(R.id.descSix);
        desSeven = v.findViewById(R.id.descSeven);
        desEight = v.findViewById(R.id.descEight);
        desNine = v.findViewById(R.id.descNine);
        desTen = v.findViewById(R.id.descTen);
        desEleven = v.findViewById(R.id.descEleven);
        desTwelve = v.findViewById(R.id.descTwelve);


//        if(images.get(0).get("size").equals("")){
//            Picasso.get().load(images.get(0).get("imageLink")).into(imageStyleOne);
//        }
//        if(images.get(2).get("size").equals("")){
//            Picasso.get().load(images.get(1).get("imageLink")).into(imageStyleOne);
//        }
//        if(images.get(1).get("size").equals("")){
//            Picasso.get().load(images.get(2).get("imageLink")).into(imageStyleOne);
//        }


        try {
            boolean isDone = false;
            for (int i = 0; i < images.size(); i++) {
                if ("350*350".equals(images.get(i).get("size"))) {
                    if (isDone) {
                        Picasso.get().load(images.get(i).get("imageLink")).into(imageStyleThree);
                    } else {
                        isDone = true;
                        Picasso.get().load(images.get(i).get("imageLink")).into(imageStyleTwo);
                    }
                }
                if ("700*350".equals(images.get(i).get("size"))) {
                    Picasso.get().load(images.get(i).get("imageLink")).into(imageStyleOne);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            pArrayList = new ArrayList<>();
            int i = 0;
            for (String key : productMap.keySet()) {
                HashMap<String, Object> pMap = productMap.get(key);
                pArrayList.add(pMap);
                setDataOnView(i);
                i++;
            }
            Log.i("ArrayList ", pArrayList.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        assignIds(view);
    }


    private void setDataOnView(int position) {
        String currencyVal = (String) pArrayList.get(position).get("currencyVal");
        String currenyPosition = (String) pArrayList.get(position).get("currenyPosition");
        Log.i("pos", currenyPosition);
        switch (position) {
            case 0:
                productOne.setText((String) pArrayList.get(position).get("productName"));
                if (currenyPosition.equals("before")) {
                    priceOne.setText(currencyVal + " " + (String) pArrayList.get(position).get("price"));
                } else {
                    priceOne.setText(" " + (String) pArrayList.get(position).get("price") + " " + currencyVal);
                }

                if ((String) pArrayList.get(position).get("discountedPrice") != null) {
                    priceDOne.setText("   " + currencyVal + " " + (String) pArrayList.get(position).get("discountedPrice"));
//                    if (currenyPosition.equals("before")) {
//                    } else {
//                        priceDOne.setText((String) pArrayList.get(position).get("discountedPrice") + "   " + currencyVal);
//                    }
                    priceOne.setPaintFlags(priceOne.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                }
                String image1 = (String) pArrayList.get(position).get("productImage");
                Picasso.get().load(image1).into(imageOne);
                desOne.setText((String) pArrayList.get(position).get("description"));
                break;
            case 1:
                productTwo.setText((String) pArrayList.get(position).get("productName"));
                if (currenyPosition.equals("before")) {
                    priceTwo.setText(currencyVal + " " + (String) pArrayList.get(position).get("price"));
                } else {
                    priceTwo.setText((String) pArrayList.get(position).get("price") + " " + currencyVal);
                }
                if ((String) pArrayList.get(position).get("discountedPrice") != null) {
                    priceDTwo.setText("   " + currencyVal + " " + (String) pArrayList.get(position).get("discountedPrice"));
//                    if (currenyPosition.equals("before")) {
//                    } else {
//                        priceDTwo.setText((String) pArrayList.get(position).get("discountedPrice") + "   " + currencyVal);
//                    }
                    priceTwo.setPaintFlags(priceOne.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                }
                String image2 = (String) pArrayList.get(position).get("productImage");
                Picasso.get().load(image2).into(imageTwo);
                desTwo.setText((String) pArrayList.get(position).get("description"));
                break;
            case 2:
                productThree.setText((String) pArrayList.get(position).get("productName"));

                if (currenyPosition.equals("before")) {

                    priceThree.setText(currencyVal + " " + (String) pArrayList.get(position).get("price"));
                } else {
                    priceThree.setText((String) pArrayList.get(position).get("price") + " " + currencyVal);
                }


                if ((String) pArrayList.get(position).get("discountedPrice") != null) {
                    priceDThree.setText("   " + currencyVal + " " + (String) pArrayList.get(position).get("discountedPrice"));
//                    if (currenyPosition.equals("before")) {
//                    } else {
//                        priceDThree.setText((String) pArrayList.get(position).get("discountedPrice") + "   " + currencyVal);
//                    }
                    priceThree.setPaintFlags(priceOne.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                }
                String image3 = (String) pArrayList.get(position).get("productImage");
                Picasso.get().load(image3).into(imageThree);
                desThree.setText((String) pArrayList.get(position).get("description"));
                break;
            case 3:
                productFour.setText((String) pArrayList.get(position).get("productName"));

                priceFour.setText(currencyVal + " " + (String) pArrayList.get(position).get("price"));
//                if (currenyPosition.equals("before")) {
//                } else {
//                    priceFour.setText((String) pArrayList.get(position).get("price") + " " + currencyVal);
//                }

                if ((String) pArrayList.get(position).get("discountedPrice") != null) {
                    priceDFour.setText("   " + currencyVal + " " + (String) pArrayList.get(position).get("discountedPrice"));
//                    if (currenyPosition.equals("before")) {
//                    } else {
//                        priceDFour.setText((String) pArrayList.get(position).get("discountedPrice") + "   " + currencyVal);
//                    }
                    priceFour.setPaintFlags(priceOne.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                }
                String image4 = (String) pArrayList.get(position).get("productImage");
                Picasso.get().load(image4).into(imageFour);
                desFour.setText((String) pArrayList.get(position).get("description"));
                break;
            case 4:
                productFive.setText((String) pArrayList.get(position).get("productName"));
                if (currenyPosition.equals("before")) {
                    priceFive.setText(currencyVal + " " + (String) pArrayList.get(position).get("price"));
                } else {
                    priceFive.setText((String) pArrayList.get(position).get("price") + " " + currencyVal);
                }
                if ((String) pArrayList.get(position).get("discountedPrice") != null) {
                    priceDFive.setText("   " + currencyVal + " " + (String) pArrayList.get(position).get("discountedPrice"));
//                    if (currenyPosition.equals("before")) {
//                    } else {
//                        priceDFive.setText((String) pArrayList.get(position).get("discountedPrice") + "   " + currencyVal);
//                    }
                    priceFive.setPaintFlags(priceOne.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                }

                String image5 = (String) pArrayList.get(position).get("productImage");
                Picasso.get().load(image5).into(imageFive);
                desFive.setText((String) pArrayList.get(position).get("description"));
                break;
            case 5:
                productSix.setText((String) pArrayList.get(position).get("productName"));
                if (currenyPosition.equals("before")) {
                    priceSix.setText(currencyVal + " " + (String) pArrayList.get(position).get("price"));
                } else {
                    priceSix.setText((String) pArrayList.get(position).get("price") + " " + currencyVal);
                }
                if ((String) pArrayList.get(position).get("discountedPrice") != null) {
                    priceDSix.setText("   " + currencyVal + " " + (String) pArrayList.get(position).get("discountedPrice"));
//                    if (currenyPosition.equals("before")) {
//                    } else {
//                        priceDSix.setText((String) pArrayList.get(position).get("discountedPrice") + "   " + currencyVal);
//                    }
                    priceSix.setPaintFlags(priceOne.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

                }

                String image6 = (String) pArrayList.get(position).get("productImage");
                Picasso.get().load(image6).into(imageSix);
                desSix.setText((String) pArrayList.get(position).get("description"));

                break;
            case 6:
                productSeven.setText((String) pArrayList.get(position).get("productName"));


                if (currenyPosition.equals("before")) {
                    priceSeven.setText(currencyVal + " " + (String) pArrayList.get(position).get("price"));
                } else {
                    priceSeven.setText((String) pArrayList.get(position).get("price") + " " + currencyVal);
                }

                if ((String) pArrayList.get(position).get("discountedPrice") != null) {
                    priceDSeven.setText("   " + currencyVal + " " + (String) pArrayList.get(position).get("discountedPrice"));
//                    if (currenyPosition.equals("before")) {
//                    } else {
//                        priceDSeven.setText((String) pArrayList.get(position).get("discountedPrice") + "   " + currencyVal);
//                    }
                    priceSeven.setPaintFlags(priceOne.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

                }

                String image7 = (String) pArrayList.get(position).get("productImage");
                Picasso.get().load(image7).into(imageSeven);
                desSeven.setText((String) pArrayList.get(position).get("description"));
                break;
            case 7:
                productEight.setText((String) pArrayList.get(position).get("productName"));
                if (currenyPosition.equals("before")) {
                    priceEight.setText(currencyVal + " " + (String) pArrayList.get(position).get("price"));
                } else {
                    priceEight.setText((String) pArrayList.get(position).get("price") + " " + currencyVal);
                }

                if ((String) pArrayList.get(position).get("discountedPrice") != null) {
                    priceDEight.setText("   " + currencyVal + " " + (String) pArrayList.get(position).get("discountedPrice"));
//                    if (currenyPosition.equals("before")) {
//                    } else {
//                        priceDEight.setText((String) pArrayList.get(position).get("discountedPrice") + "   " + currencyVal);
//                    }


                    priceEight.setPaintFlags(priceOne.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

                }


                String image8 = (String) pArrayList.get(position).get("productImage");
                Picasso.get().load(image8).into(imageEight);
                desEight.setText((String) pArrayList.get(position).get("description"));
                break;
            case 8:
                productNine.setText((String) pArrayList.get(position).get("productName"));

                if (currenyPosition.equals("before")) {
                    priceNine.setText(currencyVal + " " + (String) pArrayList.get(position).get("price"));
                } else {
                    priceNine.setText((String) pArrayList.get(position).get("price") + " " + currencyVal);
                }

                if ((String) pArrayList.get(position).get("discountedPrice") != null) {
                    priceDNine.setText("   " + currencyVal + " " + (String) pArrayList.get(position).get("discountedPrice"));
//                    if (currenyPosition.equals("before")) {
//                    } else {
//                        priceDNine.setText((String) pArrayList.get(position).get("discountedPrice") + "   " + currencyVal);
//                    }

                    priceNine.setPaintFlags(priceOne.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

                }

                String image9 = (String) pArrayList.get(position).get("productImage");
                Picasso.get().load(image9).into(imageNine);
                desNine.setText((String) pArrayList.get(position).get("description"));
                break;
            case 9:
                productTen.setText((String) pArrayList.get(position).get("productName"));


                if (currenyPosition.equals("before")) {
                    priceTen.setText(currencyVal + " " + (String) pArrayList.get(position).get("price"));
                } else {
                    priceTen.setText((String) pArrayList.get(position).get("price") + " " + currencyVal);
                }

                if ((String) pArrayList.get(position).get("discountedPrice") != null) {
                    priceDTen.setText("   " + currencyVal + " " + (String) pArrayList.get(position).get("discountedPrice"));
//                    if (currenyPosition.equals("before")) {
//                    } else {
//                        priceDTen.setText((String) pArrayList.get(position).get("discountedPrice") + "   " + currencyVal);
//                    }


                    priceTen.setPaintFlags(priceOne.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

                }

                String image10 = (String) pArrayList.get(position).get("productImage");
                Picasso.get().load(image10).into(imageTen);
                desTen.setText((String) pArrayList.get(position).get("description"));
                break;
            case 10:
                productEleven.setText((String) pArrayList.get(position).get("productName"));
                priceEleven.setText(currencyVal + " " + (String) pArrayList.get(position).get("price"));
//                if (currenyPosition.equals("before")) {
//                } else {
//                    priceEleven.setText((String) pArrayList.get(position).get("price") + " " + currencyVal);
//                }

                if ((String) pArrayList.get(position).get("discountedPrice") != null) {
                    priceDEleven.setText("   " + currencyVal + " " + (String) pArrayList.get(position).get("discountedPrice"));
//                    if (currenyPosition.equals("before")) {
//                    } else {
//                        priceDEleven.setText((String) pArrayList.get(position).get("discountedPrice") + "   " + currencyVal);
//
//                    }
                    priceEleven.setPaintFlags(priceOne.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

                }

                String image11 = (String) pArrayList.get(position).get("productImage");
                Picasso.get().load(image11).into(imageEleven);
                desEleven.setText((String) pArrayList.get(position).get("description"));
                break;
            case 11:
                productTwelve.setText((String) pArrayList.get(position).get("productName"));

                if (currenyPosition.equals("before")) {
                    priceTwelve.setText(currencyVal + " " + (String) pArrayList.get(position).get("price"));
                } else {
                    priceTwelve.setText((String) pArrayList.get(position).get("price") + " " + currencyVal);
                }

                if ((String) pArrayList.get(position).get("discountedPrice") != null) {
                    priceDTwelve.setText("   " + currencyVal + " " + (String) pArrayList.get(position).get("discountedPrice"));
//                    if (currenyPosition.equals("before")) {
//                    } else {
//                        priceDTwelve.setText((String) pArrayList.get(position).get("discountedPrice") + "   " + currencyVal);
//
//                    }

                    priceTwelve.setPaintFlags(priceOne.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                }


                String image12 = (String) pArrayList.get(position).get("productImage");
                Picasso.get().load(image12).into(imageTwelve);
                desTwelve.setText((String) pArrayList.get(position).get("description"));
                break;


        }


        // holder.txtPrice.setText((String) pArrayList.get(position).get("price"));
        //holder.txtPrice.setPaintFlags(holder.txtPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }

}
