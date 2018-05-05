package yang.com.library_system.utils;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;

/**
 * 工具类生成AlerDialog
 * Created by 杨云杰 on 2018/4/23.
 */

public class AlerDialogUtil {
    public static void generateHasBookAlerDialog(View view){
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(view.getContext());
        alertDialog.setTitle("错误信息");
        alertDialog.setMessage("相同书籍已经存在！");
        alertDialog.setCancelable(true);
        alertDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        alertDialog.show();
    }
    public static void generatePasswordAlerDialog(View view){
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(view.getContext());
        alertDialog.setTitle("错误信息");
        alertDialog.setMessage("密码不能为空！");
        alertDialog.setCancelable(true);
        alertDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        alertDialog.show();
    }
    public static void generateUserPasswordAlerDialog(View view){
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(view.getContext());
        alertDialog.setTitle("错误信息");
        alertDialog.setMessage("账号密码错误！");
        alertDialog.setCancelable(true);
        alertDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        alertDialog.show();
    }
    public static void generateSetDataAlerDialog(View view){
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(view.getContext());
        alertDialog.setTitle("错误信息");
        alertDialog.setMessage("请先创建书库！");
        alertDialog.setCancelable(true);
        alertDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        alertDialog.show();
    }
    public static void generateBookNameAlerDialog(View view){
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(view.getContext());
        alertDialog.setTitle("错误信息");
        alertDialog.setMessage("书名不能为空！");
        alertDialog.setCancelable(true);
        alertDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        alertDialog.show();
    }
    public static void generateHaveUserAlerDialog(View view){
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(view.getContext());
        alertDialog.setTitle("错误信息");
        alertDialog.setMessage("注册用户重复！");
        alertDialog.setCancelable(true);
        alertDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        alertDialog.show();
    }
    public static void generateNoBookAlerDialog(View view){
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(view.getContext());
        alertDialog.setTitle("错误信息");
        alertDialog.setMessage("没有这样的书！");
        alertDialog.setCancelable(true);
        alertDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        alertDialog.show();
    }
    public static void generateAuthorAlerDialog(View view){
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(view.getContext());
        alertDialog.setTitle("错误信息");
        alertDialog.setMessage("作者不能为空！");
        alertDialog.setCancelable(true);
        alertDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        alertDialog.show();
    }
    public static void generatePriceAlerDialog(View view){
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(view.getContext());
        alertDialog.setTitle("错误信息");
        alertDialog.setMessage("价格不能为空！");
        alertDialog.setCancelable(true);
        alertDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        alertDialog.show();
    }
    public static void generateUserAlerDialog(View view){
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(view.getContext());
        alertDialog.setTitle("错误信息");
        alertDialog.setMessage("用户名不能为空！");
        alertDialog.setCancelable(true);
        alertDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        alertDialog.show();
    }
    public static void generateDataBaseAlerDialog(View view){
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(view.getContext());
        alertDialog.setTitle("错误信息");
        alertDialog.setMessage("书库已存在，无需再次创建");
        alertDialog.setCancelable(true);
        alertDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        alertDialog.show();
    }
    public static void generateNoClientAlerDialog(View view){
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(view.getContext());
        alertDialog.setTitle("错误信息");
        alertDialog.setMessage("还没注册用户");
        alertDialog.setCancelable(true);
        alertDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        alertDialog.show();
    }
}
