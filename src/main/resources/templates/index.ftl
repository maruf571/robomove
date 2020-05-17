<!doctype html>
<html lang="en">
<head>
    <!-- === meta === -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.0.1">
    <!-- === end meta === -->

    <title>ROBOT MOVE: HOME</title>

    <link href="/vendor/bootstrap-4.5.0-dist/css/bootstrap.css" rel="stylesheet">
    <script src = "/vendor/jquery-3.5.1.min.js"></script>
</head>
<body>

        <section class=" text-center">
            <h1 class="">Robot move</h1>
        </section>

        <div class="container">
            <div class="row">

                    <div class="col-2">
                        <label for="frm-robot-script">Robot move script</label>
                    </div>
                    <div class="col-8">
                        <textarea class="form-control" id="frm-robot-script" rows="3"></textarea>
                        <br />
                        <div id="script-error" class="alert alert-danger" role="alert" style="display: none">
                            <span id="alert-message"></span>
                        </div>
                        <button id="btn-submit">Submit</button>
                    </div>
                </div>
        </div>

        <div class="container mt-2">
        <div style="text-align: center" class="mb-3">North</div>
        <div class="row">
            <div class="col-2">
                <div style="margin-top: 80%" >West</div>
            </div>
            <div class="col-8">
                <table class="table table-bordered">
                    <tr>
                        <td id="row0_col0"><sup>0, 0</sup></td>
                        <td id="row0_col1"><sup>0, 1</sup></td>
                        <td id="row0_col2"><sup>0, 2</sup></td>
                        <td id="row0_col3"><sup>0, 3</sup></td>
                        <td id="row0_col4"><sup>0, 4</sup></td>
                        <td id="row0_col5"><sup>0, 5</sup></td>
                    </tr>
                    <tr>
                        <td id="row1_col0"><sup>1, 0</sup></td>
                        <td id="row1_col1"><sup>1, 1</sup></td>
                        <td id="row1_col2"><sup>1, 2</sup></td>
                        <td id="row1_col3"><sup>1, 3</sup></td>
                        <td id="row1_col4"><sup>1, 4</sup></td>
                        <td id="row1_col5"><sup>1, 5</sup></td>
                    </tr>
                    <tr>
                        <td id="row2_col0"><sup>2, 0</sup></td>
                        <td id="row2_col1"><sup>2, 1</sup></td>
                        <td id="row2_col2"><sup>2, 2</sup></td>
                        <td id="row2_col3"><sup>2, 3</sup></td>
                        <td id="row2_col4"><sup>2, 4</sup></td>
                        <td id="row2_col5"><sup>2, 5</sup></td>
                    </tr>
                    <tr>
                        <td id="row3_col0"><sup>3, 0</sup></td>
                        <td id="row3_col1"><sup>3, 1</sup></td>
                        <td id="row3_col2"><sup>3, 2</sup></td>
                        <td id="row3_col3"><sup>3, 3</sup></td>
                        <td id="row3_col4"><sup>3, 4</sup></td>
                        <td id="row3_col5"><sup>3, 5</sup></td>
                    </tr>
                    <tr>
                        <td id="row4_col0"><sup>4, 0</sup></td>
                        <td id="row4_col1"><sup>4, 1</sup></td>
                        <td id="row4_col2"><sup>4, 2</sup></td>
                        <td id="row4_col3"><sup>4, 3</sup></td>
                        <td id="row4_col4"><sup>4, 4</sup></td>
                        <td id="row4_col5"><sup>4, 5</sup></td>
                    </tr>
                    <tr>
                        <td id="row5_col0"><sup>5, 0</sup></td>
                        <td id="row5_col1"><sup>5, 1</sup></td>
                        <td id="row5_col2"><sup>5, 2</sup></td>
                        <td id="row5_col3"><sup>5, 3</sup></td>
                        <td id="row5_col4"><sup>5, 4</sup></td>
                        <td id="row5_col5"><sup>5, 5</sup></td>
                    </tr>
                </table>
            </div>
            <div class="col-2">
                <div style="margin-top: 80%">East</div>
            </div>
        </div>

        <div style="text-align: center" class="mt-2">South</div>
    </div>

    <script>
        $(function(){
            setRobotInPosition(0, 0, 0)
        })

        $("#btn-submit").click(function () {
            $("#script-error").hide();
            const script = $("#frm-robot-script").val();
            console.log(script);
            $.ajax({
                type: "POST",
                url: "http://localhost:8080",
                data: script,
                contentType: 'text/plain',
                success: function (resp) {
                    console.log(resp);
                    setRobotInPosition(resp.row, resp.col, resp.directionDegree);
                },
                error: function (resp) {
                    console.log(resp);
                    $("#script-error").show();
                    $("#alert-message").text(resp.responseJSON.message);

                }
            })
        });
        
        function setRobotInPosition(row, col, position) {
            // remove old position
            $("#robot-image").remove();
            console.log(position);

            const rowCol = "#row"+row + "_col"+col;
            $(rowCol).append('<img id="robot-image"src="/img/robot.png" />');
            $("#robot-image").css({'transform': 'rotate('+position+'deg)'});
        }

    </script>
</body>

</html>