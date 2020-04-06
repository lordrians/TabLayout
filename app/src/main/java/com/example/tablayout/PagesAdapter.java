//package com.example.tablayout;
//
//import androidx.annotation.NonNull;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentActivity;
//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentPagerAdapter;
//import androidx.viewpager2.adapter.FragmentStateAdapter;
//
//import com.example.tablayout.fragments.ContohFragment;
//import com.example.tablayout.fragments.JenisFragment;
//import com.example.tablayout.fragments.PengertianFragment;
//
//
//public class PagesAdapter extends FragmentStateAdapter {
//
//
//    public PagesAdapter(@NonNull FragmentActivity fragmentActivity) {
//        super(fragmentActivity);
//    }
//
//    @NonNull
//    @Override
//    public Fragment createFragment(int position) {
//        switch (position){
//
//            case 0:
//                return new JenisFragment();
//            case 1:
//                return new ContohFragment();
//            default:
//                return new PengertianFragment();
//
//        }
//    }
//
//    @Override
//    public int getItemCount() {
//        return 3;
//    }
//}
//
